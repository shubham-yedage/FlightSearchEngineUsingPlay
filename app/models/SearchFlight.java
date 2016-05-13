package models;

import java.util.List;

public interface SearchFlight {
public List<ConnectingFlight> getFlights(String depLoc, String arrLoc, String flightDate);
}
