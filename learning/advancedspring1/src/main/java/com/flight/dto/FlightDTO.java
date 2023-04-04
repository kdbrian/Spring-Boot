package com.flight.dto;

import com.flight.enums.CabinClass;
import com.flight.enums.CompanyName;
import com.flight.enums.FlightType;
import com.flight.enums.TravelType;
import com.flight.model.CabinDetail;
import com.flight.model.InFlightInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlightDTO {

    private Long fligthId;
    private CompanyName companyName;//used to map in Company relation
    private FlightType flightType;
    private TravelType travelType;
    private LocalTime departureTime;
    private LocalDate departureDate;
    private LocalDate arrivalDate;
    private LocalTime arrivalTime;
    private LocalDate backDate;
    private LocalTime backTime;
    private String departureLocation;
    private String arrivalLocation;
    private LocalTime flightDuration;
    private LocalTime connectionDuration;
    private String aircraftType;
    private Set<CabinDetail> cabinDetails;
    private Set<InFlightInfo> inFlightInfos;
    private Set<String> comforts;


}
