package com.flight.service;

import com.flight.model.Flight;

import java.util.List;

public interface FlightService {

    Flight addFlight(Flight flight);
    List<Flight> getAllFLights();

}
