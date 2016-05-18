package controllers;

import models.Flight;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import utilities.FlightFormParametrsExtracter;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Application extends Controller {

    public Result index() {
        Map<String, String[]> stringMap = request().body().asFormUrlEncoded();
        try {
            List<Flight> flightList = FlightFormParametrsExtracter.createFlightObject(stringMap);
            return ok(Json.toJson(flightList));
        } catch (IOException e) {
            return internalServerError(e.getMessage());
        }
    }

}
