package com.relations._03;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StudentRepoTest {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentRepoTest(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Test
    public void saveDefaultStudent(){
        Student student = Student.builder()
                .firstName("brian")
                .lastName("kidiga")
                .email("br@dev.io")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithSchool(){
        School school = School.builder()
                .schoolName("Computer science")
                .build();
        Student student = Student.builder()
                .email("student@sch.io")
                .firstName("student")
                .lastName("tneduts")
                .school(school)
                .build();
        studentRepository.save(student);
    }

    @Test
    public void saveStudentNonNullSchool(){
        Student student = Student.builder()
                .firstName("brian")
                .lastName("kidiga")
                .email("br@dev.io")
                .school(School.builder()
                        .schoolName("Cannot be blank")
                        .build()
                )
                .build();

        studentRepository.save(student);
    }
}
