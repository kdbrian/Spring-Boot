package com.flight.model;

import com.flight.enums.CabinClass;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
public class CabinDetail {

    @Enumerated(EnumType.STRING)
    private CabinClass cabinClass;
    private String baggage;
    private String cancellation;
    private String rebooking;
    private String refund;
    private String fare;
}
