package controllers;

import models.Flight;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;

public class Application extends Controller {

    public Result index() {
      List<Flight> flightList=FlightSearchEngineServer.createFlightObject(request().body().asFormUrlEncoded());
        return ok(Json.toJson(flightList));
    }

}
