package com.relations._03;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class SchoolRepoTest {


    private final SchoolRepository schoolRepository;

    @Autowired
    public SchoolRepoTest(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    @Test
    void contextLoads(){}

    @Test
    public void testSaveSchool(){
        School school = School.builder()
                .schoolName("Pure and applied sciences")
                .build();
        schoolRepository.save(school);
    }

    @Test
    public void testFetchSchools(){
        List<School> schools = schoolRepository.findAll();
        System.out.println("schools = " + schools);
    }

}
