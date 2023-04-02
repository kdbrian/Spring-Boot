package com.data.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

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


    @ManyToOne(cascade = CascadeType.ALL)//maps many courses to one teacher
    @JoinColumn(
            name = "teacherId",
            referencedColumnName = "Id"
    )//the course is has a new column that identifies the tutor who delivers it
    private Teacher teacher;

    @ManyToMany(
            cascade = CascadeType.ALL
    )
    @JoinTable(
            name = "student_course_mapping",
            joinColumns = @JoinColumn(//first column from the first table
                    name = "course_id",//column name
                    referencedColumnName = "courseId"//referenced field
            ),
            inverseJoinColumns = @JoinColumn(//second column from second table
                    name = "student_id",//column name
                    referencedColumnName = "studentId"//referenced field
                    //the list item(student) is the one used in the inversecolumnjoin
            )
    )
    private List<Student> students;

    //method to add students to the list
    public void addStudent(Student student){
        if(students == null) students = new ArrayList<>();
        students.add(student);
    }
}
