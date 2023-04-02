package com.data.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "course")
public class CourseMaterial {

    @Id
    @SequenceGenerator(
            allocationSize = 1,
            name = "course_material_seq",
            sequenceName = "course_material_seq"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_material_seq"
    )
    private Long courseMaterialId;
    private String url;

    @OneToOne(
            cascade = CascadeType.ALL,//cascading
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "course_id",//name of the column in constraint table
            referencedColumnName = "courseId"//which column in the constraint class
    )
    private Course course;

}
