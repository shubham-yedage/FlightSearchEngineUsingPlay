package utilities;

import models.ConnectingFlight;
import models.Flight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchFlights {
	public static final String STRING_COMMA = ",";
	protected ArrayList<String> listPath = new ArrayList<String>();
	String newLine = "";
	BufferedReader br = null;

	public SearchFlights() {
	}

	private Map<Integer, Comparator<Flight>> sorter = new HashMap<>();

	public SearchFlights(List<String> path,
			Map<Integer, Comparator<Flight>> extSorter) {

		for (String p : path) {
			listPath.add(p);
		}

		sorter.put(2, new FareDurationComparator());
		sorter.putAll(extSorter);

	}

	public List<Flight> getFlight(String depLoc, String arrLoc,
								  String flightDate, int choice, String connFlightStatus) throws FileNotFoundException, IOException {

			for (String path : listPath) {
				new BufferedReader(new FileReader(path)).readLine();
			}
		List<ConnectingFlight> flList1 = new SearchDirectFLights(listPath,
				new HashMap<Integer, Comparator<Flight>>()).getFlights(depLoc,
				arrLoc, flightDate);
		if(connFlightStatus.equals("true")) {
			flList1.addAll(new SearchConnectingFlights(listPath,
					new HashMap<Integer, Comparator<Flight>>()).getFlights(depLoc,
					arrLoc, flightDate));
		}
		List<ConnectingFlight> flList = sortByPreference(flList1, choice);
		FinalList fl=new FinalList();		
		List<Flight> flList2=fl.getFinalFlightList(flList);
		return flList2;
	}

	private List<ConnectingFlight> sortByPreference(List<ConnectingFlight> flList, int choice) {

		Comparator<Flight> flightComparator = sorter.get(choice);
		if (flightComparator == null) {
			Collections.sort(flList);
			return flList;
		}
		Collections.sort(flList, flightComparator);
		return flList;
	}
}
