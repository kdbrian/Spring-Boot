package com.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.data.entity.Student;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

    //adding own methods
    //should be camel case and the attribute names must match their declaration
    //there are KW that can be used to make the methods more specific
    public List<Student> findByFirstName(String firstName);

    //find all students whose first name contains a given character
    public List<Student> findByFirstNameContaining(String firstName);

    public List<Student> findByLastNameNotNull();

    public List<Student> findByGuardianName(String guardianName);


    /*
    * for the above two methods the changing of the Keywords (And , Or)
    * makes the results of the methods different
    * 
    * */

    List<Student> findByFirstNameAndLastName(String fname, String lname);
    List<Student> findByFirstNameOrLastName(String fname, String lname);

}
