package com.relations._01;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
public class EmployeeRepoTest {

    private final EmployeeRepository employeeRepository;


    @Autowired
    public EmployeeRepoTest(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Test
    public void testInsertEmployee(){
        Employee employee = Employee.builder()
                .fname("brian")
                .lname("Kidiga")
                .dateJoined(new Date(System.currentTimeMillis()))
                .isActive(true)
                .email("brian@dev.io")
                .build();

        employeeRepository.save(employee);
    }

    @Test
    public void testFetchEmployees(){
        List<Employee> employees = employeeRepository.findAll();
        System.out.println("employees = " + employees);
    }

}
