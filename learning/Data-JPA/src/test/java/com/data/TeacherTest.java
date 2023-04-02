package com.data;

import com.data.entity.Course;
import com.data.entity.CourseMaterial;
import com.data.entity.Teacher;
import com.data.repository.TeacherRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TeacherTest {

    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherTest(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Test
    public void SaveTeacher(){
        Course course = Course.builder()
                .courseTitle("Hide and seek")
                .credit(5)
                .build();
        Course course2 = Course.builder()
                .courseTitle("Hide and seek")
                .credit(5)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Brian")
                .lastName("Kidiga")
//                .courseList(List.of(course, course2))
                .build();

        System.out.println(teacherRepository.save(teacher));
    }

    @Test
    public void saveTeacherCourse(){

        Teacher teacher = Teacher.builder()
                .firstName("Yellow")
                .lastName("Brown")
                .build();

        Course course = Course.builder()
                .courseTitle("Well..")
                .credit(7)
                .teacher(teacher)
                .build();

        System.out.println(teacherRepository.save(teacher));
    }

    @Test
    public void getTeachers(){
        List<Teacher> teachers = teacherRepository.findAll();

        System.out.println("teachers = " + teachers);
    }
}
