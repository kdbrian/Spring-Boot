package com.relations._01;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
public class EmployeeRepoTest {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;


    @Autowired
    public EmployeeRepoTest(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
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
    public void testInsertEmployeeWithDepartment(){
        //cascading must be allowed to all to enable creation of both items

        Department department = Department.builder()
                .departmentName("No bitches 2")
                .departmentLocation("Crib Int")
                .departmentHead("Brian Kidiga")
                .build();

        Employee employee = Employee.builder()
                .department(department)
                .dateJoined(new Date(System.currentTimeMillis()))
                .fname("j")
                .lname("cole")
                .email("j@cole.io")
                .isActive(true)
                .build();

        employeeRepository.save(employee);
    }

    @Test
    public void testInsertEmployeeWithDepartmentExisting(){
        //assuming we already know the id of the dept to which the employee shud be registered
        Department department = departmentRepository.findById(1l).get();
        Adress adress = Adress.builder()
                .location("Tano nane")
                .zipCode(58l)
                .build();
        Employee employee = Employee.builder()
                .fname("yellow")
                .lname("boy")
                .email("yellow@boy.io")
                .isActive(true)
                .dateJoined(new Date(System.currentTimeMillis()))
                .adress(adress)
                .build();

        employeeRepository.save(employee);
    }
    @Test
    public void testFetchEmployees(){
        List<Employee> employees = employeeRepository.findAll();
        System.out.println("employees = " + employees);
    }

}
