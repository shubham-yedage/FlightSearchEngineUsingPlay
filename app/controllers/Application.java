package controllers;

import models.Flight;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;
import java.util.Map;

public class Application extends Controller {

    public Result index() {
        Map<String, String[]> stringMap = request().body().asFormUrlEncoded();
        List<Flight> flightList=FlightSearchEngineServer.createFlightObject(stringMap);
        return ok(Json.toJson(flightList));
    }

}
