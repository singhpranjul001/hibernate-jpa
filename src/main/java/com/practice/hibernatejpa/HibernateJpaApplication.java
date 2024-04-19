package com.practice.hibernatejpa;

import com.practice.hibernatejpa.dao.StudentDAO;
import com.practice.hibernatejpa.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class HibernateJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateJpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner->{
			//createStudent(studentDAO);

			createMultipleStudents(studentDAO);

			//readStudent(studentDAO);

			//queryForStudent(studentDAO);

			//queryForStudentByLastName(studentDAO);

			//updateStudent(studentDAO);

			//deleteStudent(studentDAO);

			//deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting All Students...");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted row count: " + numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;
		System.out.println("Deleting Student id: " + studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		//retrieve student based on the id: Primary Key
		int studentId=1;
		System.out.println("Getting the student with id: " + studentId);
		Student myStudent = studentDAO.findById(studentId);

		//change firstName to "Pranjul"
		System.out.println("Updating the Student...");
		myStudent.setFirstName("Pranjul");

		//update the Student
		studentDAO.update(myStudent);

		//Display the updated student
		System.out.println("Updated Student: " + myStudent);
	}

	private void queryForStudentByLastName(StudentDAO studentDAO) {
		//get the list of Students
		List<Student> theStudents = studentDAO.findByLastName("sangli");

		//display the list
		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void queryForStudent(StudentDAO studentDAO) {
		//get a list of Students
		List<Student> theStudents = studentDAO.findAll();

		//display the list of Students
		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {

		//create a student object
		System.out.println("Creating a new student...");
		Student tempStudent=new Student("Poorav", "Jha", "jhaPoorav@gmail.com");

		//save the student
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		//display id of the saved student
		int theId= tempStudent.getId();
		System.out.println("Saved Student. Generated id: " + theId);

		//retrieve the student based on the id:Primary Key
		System.out.println("Retrieving the Student with the given id: " + theId);
		Student myStudent= studentDAO.findById(theId);

		//display the student
		System.out.println("Found the Student: " + myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		//create multiple students
		System.out.println("Creating 3 student object...");
		Student tempStudent1 = new Student("Pranav", "Sangli", "sangli_cool@gmail.com");
		Student tempStudent2 = new Student("Abhishek", "Yadav", "abhishekyadav11@gmail.com");
		Student tempStudent3 = new Student("Priti", "Roy", "roypriti007@gmail.com");

		//save the student objects
		System.out.println("Saving the students...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO) {
		//create the student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Rahul", "Sharma", "rahul.sharma@gmail.com");

		//save the student object
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		//display the id of the save student
		System.out.println("Saved student: Generated id: " + tempStudent.getId());
	}
}
