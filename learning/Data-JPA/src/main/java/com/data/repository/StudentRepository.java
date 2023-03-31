package com.data.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.data.entity.Student;

import java.util.List;

@Repository
@EnableJpaRepositories
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

//    alternatively the method that require prior
//    implementation can be annotated with @Query
    @Query("select s from Student s where s.email = ?1")//JPQL QUERY
    //passing class& attribute names not table & column names
    //the ?# represents the parameter number(?1 -> parameter 1)
    public Student getStudentByEmailAdress(String email);

    @Query("SELECT s.firstName from Student s where s.email = ?1")
    //whenever jus a specific field is needed
    public String getStudentFirstNameByEmailAdress(String email);

    @Query(
            value = "select * from tbl_student s where s.email = ?1",
            nativeQuery = true
    )//native queries just like normal sql
    public Student getStudentByEmailAdressNative(String email);


    @Query(
            value = "select * from tbl_student s where s.email = :email ",
            nativeQuery = true
    )//native queries with named parameters
    public Student getStudentByEmailAdressNativeNamedParam( @Param("email") String email);


    @Modifying//make this method modify persisted data
    @Transactional//must tbe there
    // alows execution of certain transactions (modifying, delete ) and are committed at once
    @Query(
            value = "update tbl_student set first_name = :firstname where email = :email",
            nativeQuery = true
    )
    int updateStudentNameByEmail(@Param("firstname") String firstname, @Param("email") String email);
}
