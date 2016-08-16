package controllers;

import com.fasterxml.jackson.databind.JsonNode;
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
            JsonNode jsonNode = Json.toJson(flightList);
            return ok(jsonNode);
        } catch (IOException e) {
            return internalServerError(e.getMessage());
        }
    }

}
