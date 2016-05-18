package utilities;

import models.ConnectingFlight;
import models.Flight;
import models.SearchFlight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class SearchConnectingFlights extends SearchFlights implements
		SearchFlight {

	public SearchConnectingFlights() {
		super();
	}

	public SearchConnectingFlights(List<String> path,
			Map<Integer, Comparator<Flight>> extSorter) {
		super(path, extSorter);
	}

	@Override
	public List<ConnectingFlight> getFlights(String depLoc, String arrLoc,
											 String flightDate) {
		List<Flight> flList1 = new ArrayList<>();
		List<Flight> flList2 = new ArrayList<>();

		try {
			for (String path : listPath) {
				br = new BufferedReader(new FileReader(path));
				br.readLine();
				while ((newLine = br.readLine()) != null) {
					String[] readColumn = newLine.split(STRING_COMMA);

					if (readColumn[2].equalsIgnoreCase(arrLoc) != true) {
						if (((readColumn[1].equalsIgnoreCase(depLoc)) && (readColumn[3]
								.equalsIgnoreCase(flightDate))) != (readColumn[2]
										.equalsIgnoreCase(arrLoc))) {
							flList1.add(new Flight(readColumn[0],
									readColumn[1], readColumn[2],
									readColumn[3], Integer
									.parseInt(readColumn[4]), Float
									.parseFloat(readColumn[5]), Float
									.parseFloat(readColumn[6])));
						}
					}

					if (readColumn[1].equalsIgnoreCase(depLoc) != true) {
						if (((readColumn[2].equalsIgnoreCase(arrLoc)) && (readColumn[3]
								.equalsIgnoreCase(flightDate))) != (readColumn[1]
										.equalsIgnoreCase(depLoc))) {
							flList2.add(new Flight(readColumn[0],
									readColumn[1], readColumn[2],
									readColumn[3], Integer
									.parseInt(readColumn[4]), Float
									.parseFloat(readColumn[5]), Float
									.parseFloat(readColumn[6])));
						}
					}
				}
			}
			br.close();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		List<ConnectingFlight> flList = getConnectingFlights(flList1, flList2);

		return flList;
	}

	private List<ConnectingFlight> getConnectingFlights(List<Flight> conFlight1,
			List<Flight> conFlight2) {
		List<ConnectingFlight> finalConnFliightList = new ArrayList<>();
		List<Flight> supportList = new ArrayList<>();
		LinkFlights lf = new LinkFlights();

		for (Flight fl : conFlight1) {
			for (Flight fl1 : conFlight2) {
				if ((lf.linkFlights(fl.getArrival(), fl1.getDeparture(),
						fl.getDepTime(), fl.getDuration(), fl1.getDepTime())) == true) {
					finalConnFliightList.add(new ConnectingFlight(fl.getName(),
							fl.getDeparture(), fl1.getArrival(), fl
							.getDepDate(), fl.getDepTime(), addTo(
									fl.getDuration(), fl1.getDuration()),
									addTo(fl.getFare(), fl1.getFare()), fl1.getName(),
									fl.getArrival(),fl1.getDepTime(),fl1.getDuration(),fl1.getFare()));
					supportList.add(fl);
					supportList.add(fl1);
				}
			}
		}

		return finalConnFliightList;
	}

	private float addTo(float var1, float var2)
	{
		BigDecimal bd = new BigDecimal(Float.toString(var1+var2));
		bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
		return bd.floatValue();
	}

}
