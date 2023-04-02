package com.data;

import com.data.entity.Course;
import com.data.entity.CourseMaterial;
import com.data.entity.Teacher;
import com.data.repository.CourseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
public class CourseTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public  void testInsertCourse(){
        Course course = Course.builder()
                .courseTitle("Clinical Medicine")
                .credit(5)
                .build();

        courseRepository.save(course);
    }

    @Test
    public  void printCourses(){
        System.out.println(courseRepository.findAll());
    }


    //pagination and sorting
    @Test
    public void  findAllPagination(){
        Pageable firstThreeRecord = PageRequest.of(0,3);//specifies that page zero to contain 3 records
        Pageable secondTwoRecord = PageRequest.of(1,2);

        List<Course> courses = courseRepository.findAll(secondTwoRecord).getContent();

        long totalElements = courseRepository.findAll(secondTwoRecord).getTotalElements();
        System.out.println("totalElements = " + totalElements);
        long totalPages = courseRepository.findAll(secondTwoRecord).getTotalPages();
        System.out.println("totalPages = " + totalPages);
        System.out.println("courses = " + courses);
    }

    @Test
    public void findAllSorting(){
        Pageable sortByTitle = PageRequest.of(0, 2,
                Sort.by("courseTitle")
        );

        Pageable sortByCredit = PageRequest.of(0, 2,
                Sort.by("credit").descending()
        );

        Pageable sortByTitleAndCreditDesc = PageRequest.of(0, 2,
                Sort.by( "courseTitle").descending()
                        .and(Sort.by("credit"))
        );

        List<Course> courses = courseRepository.findAll(sortByTitle).getContent();
        System.out.println("courses = " + courses);
    }

    @Test
    public  void testfindByTitleContaining(){

        Pageable firstPageTenRecs = PageRequest.of(0, 10, Sort.by("credit"));
        //looks for first 10 records containing C in the title
        List<Course> courses = courseRepository.findByCourseTitleContaining("C", firstPageTenRecs).getContent();

        System.out.println("courses = " + courses);
    }
}
