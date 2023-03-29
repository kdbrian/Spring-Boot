package com.data;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.data.entity.Student;
import com.data.repository.StudentRepository;

@SpringBootTest
class DataJpaApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Test
	public void saveStudent() {
		
		Student student = Student.builder()
				.firstName("Brian")
				.lastName("Kidiga")
				.email("brian@dev.io")
				.build();
		
		studentRepository.save(student);
	}

}
