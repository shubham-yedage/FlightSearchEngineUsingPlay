package utilities;

import models.ConnectingFlight;
import models.Flight;

import java.util.ArrayList;
import java.util.List;

public class FinalList {

	public List<Flight> getFinalFlightList(List<ConnectingFlight> flList) {
		List<Flight> finalList = new ArrayList<>();
		for (ConnectingFlight cfl : flList) {			
			if ((cfl.getConnFlightName().equalsIgnoreCase(""))) {
				finalList.add(cfl);
			} else {
				finalList.add(cfl);
				finalList.add(new Flight(cfl.getName(), cfl.getDeparture(), cfl
						.getConnLoc(), cfl.getDepDate(), cfl.getDepTime(),
						subAttributes(cfl.getDuration(),
								cfl.getConnFlightDuration()), subAttributes(
										cfl.getFare(), cfl.getConnFlightFare())));
				finalList.add(new Flight(cfl.getConnFlightName(), cfl
						.getConnLoc(), cfl.getArrival(), cfl.getDepDate(), cfl
						.getConDepTime(), cfl.getConnFlightDuration(), cfl
						.getConnFlightFare()));
			}
		}
		return finalList;
	}

	private float subAttributes(float val1, float val2) {
		return (val1 - val2);
	}
}
