package utilities;

import models.Flight;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class FlightFormParametrsExtracter {

    public static SearchFlights sf;

    public static List<Flight> createFlightObject(Map<String, String[]> stringMap) throws IOException{
        Map<String, String> form = new HashMap<>();

        for (String key : stringMap.keySet()) {
            form.put(key, stringMap.get(key)[0]);
        }

        String depLoc = form.get("deploc");
        String arrLoc = form.get("arrloc");
        String flightDate = form.get("date");
        String stringChoice = form.get("sortchoice");
        int choice = Integer.parseInt(stringChoice);
        String connFlightStatus=form.get("connflightstatus");

        //--------Loading resources
        ClassLoader loader = FlightFormParametrsExtracter.class.getClassLoader();
        URL resource = loader.getResource("models/resources");
        File dir = new File(resource.getPath());
        List<String> path = new ArrayList<>();
        for (File f : dir.listFiles()) {
            path.add(f.getAbsolutePath());
        }

        //---------get Flights
        sf = new SearchFlights(path, new HashMap<Integer, Comparator<Flight>>());
        List<Flight> flightList = sf.getFlight(depLoc, arrLoc, flightDate,
                choice, connFlightStatus);
        if(flightList.isEmpty())
        {
            throw new FileNotFoundException("No records Found");
        }

        return flightList;
    }
}