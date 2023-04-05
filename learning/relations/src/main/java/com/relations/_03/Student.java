package com.relations._03;

/*
* since one student can only belong to one school
* i.e. StudentN --> School of Medicine
* this creates a Many to one(many students can belong to the same school)
* */

import jakarta.persistence.Entity;
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
}
