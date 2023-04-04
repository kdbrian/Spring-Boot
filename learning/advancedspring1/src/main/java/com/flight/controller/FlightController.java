package com.flight.controller;

import com.flight.dto.FlightDTO;
import com.flight.model.Flight;
import com.flight.service.FlightService;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

    private final FlightService flightService;


    //an object for mapping objects from source to destination
    public final ModelMapper modelMapper;

    PropertyMap<Flight, FlightDTO> companyFieldMapping  = new PropertyMap<Flight, FlightDTO>() {
        @Override
        protected void configure() {
            map().setCompanyName(source.getCompany().getCompanyName());
            map().setCabinDetails(source.getCompany().getCabinDetails());
            map().setInFlightInfos(source.getCompany().getInFlightInfos());
        }
    };


    @Autowired
    public FlightController(FlightService flightService, ModelMapper modelMapper) {
        this.flightService = flightService;
        this.modelMapper = modelMapper;
        modelMapper.addMappings(companyFieldMapping);//adding the mapping to the wrapper
    }

    @PostMapping("/")
    public ResponseEntity<Flight> addFlight(@RequestBody Flight flight){
        return new ResponseEntity<>(
                flightService.addFlight(flight),
                new HttpHeaders(),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/")
    public ResponseEntity<List<FlightDTO>> getFlights(){
        List<FlightDTO> flightDTOS = flightService.getAllFLights().stream().map(
                flight -> modelMapper.map(flight, FlightDTO.class)
        ).collect(Collectors.toList());

        return new ResponseEntity<>(
                flightDTOS,
                new HttpHeaders(),
                HttpStatus.OK
        );
    }
}