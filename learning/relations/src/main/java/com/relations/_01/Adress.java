package com.relations._01;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
/***
 * A Embeddable class works to modularize the characteristics whilist not introducing new
 * entity classes
 */
public class Adress {

    private String location;
    private Long zipCode;
}
