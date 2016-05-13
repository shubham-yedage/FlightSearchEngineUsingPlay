package controllers;

import models.Flight;
import models.SearchFlight;
import utilities.SearchFlights;

import java.io.File;
import java.net.URL;
import java.util.*;
import static play.mvc.Results.ok;

public class FlightSearchEngineServer {


	public static List<Flight> createFlightObject(Map<String, String[]> stringMap) {
	Map<String, String> form=new HashMap<>();

		for(String key: stringMap.keySet())
		{
			form.put(key, stringMap.get(key)[0]);
		}
		
		String depLoc=form.get("depLoc");
		String arrLoc=form.get("arrLoc");
		String flightDate=form.get("flightdate");
		int choice=1;
		SearchFlights sf;
		//--------Loading resources
		URL resource = FlightSearchEngineServer.class.getClassLoader()
				.getResource("resources");
		File dir = new File(resource.getPath());
		List<String> path = new ArrayList<>();
		for (File f : dir.listFiles()) {
			path.add(f.getAbsolutePath());
		}
		//---------get Flights
		sf = new SearchFlights(path, new HashMap<Integer, Comparator<Flight>>());
		return sf.getFlight(depLoc, arrLoc, flightDate,
				choice);
	}
}