package com.data;

import com.data.entity.Course;
import com.data.repository.CourseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CourseTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public  void testInsertCourse(){
        Course course = Course.builder()
                .courseTitle("Computer Science")
                .credit(90000)
                .build();

        courseRepository.save(course);
    }
}
