package com.relations._01;

import jakarta.persistence.Embeddable;

@Embeddable
public class Adress {

    private String location;
    private Long zipCode;
}
