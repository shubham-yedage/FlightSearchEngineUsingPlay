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

	public String headers = "";

	public void setHeaders(String headers) {
		this.headers = headers;
	}

	public String getHeaders() {
		return headers;
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
			String flightDate, int choice) {
		try {
			for (String path : listPath)
				setHeaders(new BufferedReader(new FileReader(path)).readLine());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<ConnectingFlight> flList1 = new SearchDirectFLights(listPath,
				new HashMap<Integer, Comparator<Flight>>()).getFlights(depLoc,
				arrLoc, flightDate);
		flList1.addAll(new SearchConnectingFlights(listPath,
				new HashMap<Integer, Comparator<Flight>>()).getFlights(depLoc,
				arrLoc, flightDate));

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
