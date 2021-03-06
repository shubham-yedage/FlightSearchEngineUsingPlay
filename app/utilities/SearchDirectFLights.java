package utilities;

import models.ConnectingFlight;
import models.Flight;
import models.SearchFlight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class SearchDirectFLights extends SearchFlights implements SearchFlight {
	public SearchDirectFLights() {
		super();
	}

	public SearchDirectFLights(List<String> path,
			Map<Integer, Comparator<Flight>> extSorter) {
		super(path, extSorter);
	}

	@Override
	public List<ConnectingFlight> getFlights(String depLoc, String arrLoc, String flightDate) {
		List<ConnectingFlight> flList = new ArrayList<>();
		try {
			int ip = 0;
			for (String path : listPath) {
				br = new BufferedReader(new FileReader(path));
				br.readLine();
				while ((newLine = br.readLine()) != null) {
					String[] readColumn = newLine.split(STRING_COMMA);
					if ((readColumn[1].equalsIgnoreCase(depLoc))
							&& (readColumn[2].equalsIgnoreCase(arrLoc))
							&& (readColumn[3].equalsIgnoreCase(flightDate))) {
						flList.add(new ConnectingFlight(readColumn[0],
								readColumn[1], readColumn[2], readColumn[3],
								Integer.parseInt(readColumn[4]), Float
								.parseFloat(readColumn[5]), Float
								.parseFloat(readColumn[6])));
					}
				}
			}
			br.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return flList;
	}

}
