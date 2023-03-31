package com.data;

import com.data.entity.Guardian;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.data.entity.Student;
import com.data.repository.StudentRepository;

import java.util.List;

@SpringBootTest
class DataJpaApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private StudentRepository studentRepository;

	@Test
	/* persists a student object to the database without the guardian details */
	public void saveStudentTest() {

		Student student = Student.builder()
				.firstName("Brian")
				.lastName("Kidiga")
				.email("brian3@dev.io")
				.build();

		studentRepository.save(student);
	}

	@Test
	/* fetches the list of rows from the students table in the database*/
	public void getAllStudents(){
		System.out.println(studentRepository.findAll());
	}

	@Test
	/* persists a student object with guardian details to the database*/
	public void saveStudentGuardian(){

		Guardian guardian = Guardian.builder()
				.name("Hellen Wanja")
				.phone("0722359739")
				.email("hellen@yahoo.com")
				.build();

		Student student = Student.builder()
				.firstName("Benard")
				.lastName("Ngugi")
				.email("ben@dev.io")
				.guardian(guardian)
				.build();

		studentRepository.save(student);
	}


	@Test
	/* gets a student by there first name*/
	public void printStudentByFirstName(){
		List<Student> students = studentRepository.findByFirstName("brian");
		System.out.println(students);
	}

	@Test
	/* find a list of all students whose name contains the specified character sequence*/
	public void printByFirstNameContaining(){
		List<Student> students = studentRepository.findByFirstNameContaining("B");
		System.out.println(students);
	}


	@Test
	public void printStudentbyGuardianName(){
		System.out.println(studentRepository.findByGuardianName("Hellen Wanja"));
	}

	@Test
	public void printtStudentByLastName(){
		System.out.println(studentRepository.findByLastNameNotNull());
	}

	@Test
	public void printStudentByFirstNameLastName(){
		System.out.println(studentRepository.findByFirstNameAndLastName("Benard", "Ngugi"));
	}

	@Test
	public void printStudentByFirstNameOrLastName(){
		System.out.println(studentRepository.findByFirstNameOrLastName("Brian", "Ngugi"));
	}

	@Test
	public void testGetStudentByMailAdress(){
		System.out.println("student = " + studentRepository.getStudentByEmailAdress("brian3@dev.io"));
	}

	@Test
	public void testGetStudentFirstNameByMailAdress() {
		System.out.println("student = " + studentRepository.getStudentFirstNameByEmailAdress("brian3@dev.io"));
	}

	@Test
	public void testGetStudentFirstNameByMailAdressNative() {
		System.out.println("student = " + studentRepository.getStudentByEmailAdressNative("brian3@dev.io"));
	}

	@Test
	public void testGetStudentFirstNameByMailAdressNativeNamedParam() {
		System.out.println("student = " + studentRepository.getStudentByEmailAdressNativeNamedParam("brian3@dev.io"));
	}

	@Test
	public void updateStudentNameByEmailTest(){
		System.out.println(studentRepository.updateStudentNameByEmail("brian", "brian3@dev.io"));
	}
}
