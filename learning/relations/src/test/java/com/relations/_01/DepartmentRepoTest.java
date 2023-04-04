package com.relations._01;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class DepartmentRepoTest {

    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentRepoTest(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Test
    public void testInsertDepartment(){
        Department department = Department.builder()
                .departmentHead("Brian Kidiga")
                .departmentLocation("Crib Int.")
                .departmentName("No Bitches")
                .build();

        departmentRepository.save(department);
    }

    @Test
    public void fetchAllDepartments(){
        List<Department> departments = departmentRepository.findAll();
        System.out.println("departments = " + departments);
    }
}
