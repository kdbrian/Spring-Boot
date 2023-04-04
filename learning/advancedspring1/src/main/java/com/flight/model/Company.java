package com.flight.model;

import jakarta.persistence.*;

import java.util.Set;

import com.flight.enums.CompanyName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Enumerated(EnumType.STRING)
    private CompanyName companyName;

    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    private Set<Flight> flights;

    @ElementCollection//means that the collection will be of embeddable elements
    @CollectionTable(name = "cabin_details", joinColumns = @JoinColumn(name = "company_id"))
    private Set<CabinDetail> cabinDetails;

    @ElementCollection//means that the collection will be of embeddable elements
    @CollectionTable(name = "inflight_infos", joinColumns = @JoinColumn(name = "company_id"))
    private Set<InFlightInfo> inFlightInfos;
}
