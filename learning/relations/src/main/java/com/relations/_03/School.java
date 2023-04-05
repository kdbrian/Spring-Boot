package com.relations._03;
/*
* one school can accommodate many students
*
* School of engineering ->{std1, std2, ..., stdn }
* this brings about a many-to-one relationship
* */

import jakarta.persistence.Entity;
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

    private Long schoolId;

    private String schoolName;

}
