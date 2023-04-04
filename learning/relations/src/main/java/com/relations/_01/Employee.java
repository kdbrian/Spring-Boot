package com.relations._01;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Employee {

    private Long id;
    private String fname;
    private String lname;

    private Date dateJoined;

    private Boolean isActive;
}
