package com.data.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course {

    @Id
    @SequenceGenerator(
            name = "course_seq",
            sequenceName = "course_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_seq"
    )
    private Long courseId;
    private String courseTitle;
    private Integer credit;

    @OneToOne(mappedBy = "course")
    private CourseMaterial courseMaterial;
    //allows the course to be printed together with the course material


    @ManyToOne//maps many courses to one teacher
    @JoinColumn(
            name = "teacherId",
            referencedColumnName = "Id"
    )//the course is has a new column that identifies the tutor who delivers it
    private Teacher teacher;
}
