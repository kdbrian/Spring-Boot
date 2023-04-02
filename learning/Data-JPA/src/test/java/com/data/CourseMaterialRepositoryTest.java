package com.data;

import com.data.entity.Course;
import com.data.entity.CourseMaterial;
import com.data.repository.CourseMaterialRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void testSaveCOurseMaterial(){
        Course course = Course.builder()
                .courseTitle("Computer Science")
                .credit(90000)
                .build();//trying to add this to a course material fails since it need a reference from the course table
        //for that case cascading is used
        CourseMaterial courseMaterial = CourseMaterial.builder()
                .course(course)
                .url("Http://127.0.0.1")
                .build();

        System.out.println(courseMaterialRepository.save(courseMaterial));
    }

    @Test
    public void testPrintCOurseMaterial(){
        System.out.println(courseMaterialRepository.findAll());
    }
}
