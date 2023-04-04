package com.flight.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

import com.flight.enums.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fligthId;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;//used to map in Company relation

    @Column(name = "flight_type")
    @Enumerated(EnumType.STRING)
    private FlightType flightType;

    @Column(name = "travel_type")
    @Enumerated(EnumType.STRING)
    private TravelType travelType;

    private LocalDate arrivalDate;
    private LocalDate departureDate;
    private LocalDate backDate;

    private LocalTime departureTime;
    private LocalTime arrivalTime;
    private LocalTime backTime;

    private String departureLocation;
    private String arrivalLocation;

    private LocalTime flightDuration;

    private LocalTime connectionDuration;

    private String aircraftType;
}
