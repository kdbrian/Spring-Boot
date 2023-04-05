package com.relations._03;
/*
* one school can accommodate many students
*
* School of engineering ->{std1, std2, ..., stdn }
* this brings about a many-to-one relationship
* */

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class School {

    @Id
    @SequenceGenerator(name = "school_seq", sequenceName = "school_seq", allocationSize = 1)
    @GeneratedValue( strategy = GenerationType.SEQUENCE,generator = "school_seq")
    private Long schoolId;

    private String schoolName;

}
