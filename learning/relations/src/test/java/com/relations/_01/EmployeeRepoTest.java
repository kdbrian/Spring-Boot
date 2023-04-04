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
    public void testInsertEmployeeAdress(){
        Adress adress = Adress.builder()
                .location("Karatina")
                .zipCode(1957l)
                .build();
        Employee employee = Employee.builder()
                .adress(adress)
                .email("brian2@dev.io")
                .isActive(true)
                .fname("brian")
                .lname("the II")
                .dateJoined(new Date(System.currentTimeMillis()))
                .build();

        employeeRepository.save(employee);
    }

    @Test
    public void testFetchEmployees(){
        List<Employee> employees = employeeRepository.findAll();
        System.out.println("employees = " + employees);
    }

}
