package controllers;

import models.Flight;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Application extends Controller {

    public Result getHeaders() {
        try {
            String flightHeaders = FlightSearchEngineServer.getFlightHeaders();
            return ok(flightHeaders);
        } catch (IOException e) {
            return internalServerError(e.getMessage());
        }

    }

    public Result index() {
        Map<String, String[]> stringMap = request().body().asFormUrlEncoded();
        try {
            List<Flight> flightList = FlightSearchEngineServer.createFlightObject(stringMap);
            return ok(Json.toJson(flightList));
        } catch (IOException e) {
            return internalServerError(e.getMessage());
        }
    }

}
