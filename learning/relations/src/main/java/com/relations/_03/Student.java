package com.relations._03;

/*
* since one student can only belong to one school
* i.e. StudentN --> School of Medicine
* this creates a Many to one(many students can belong to the same school)
* */

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {

    @Id
    @SequenceGenerator(name = "stud_seq", sequenceName = "stud_seq", allocationSize = 11)
    @GeneratedValue( strategy = GenerationType.SEQUENCE,generator = "stud_seq")
    private Long studentId;

    private String firstName;
    private String lastName;
    private String email;


    @ManyToOne( cascade = CascadeType.ALL)
    @JoinColumn(
            name = "school",
            referencedColumnName = "schoolId",
            nullable = false//makes not being able to save student without the school id
    )

    private School school;

}
