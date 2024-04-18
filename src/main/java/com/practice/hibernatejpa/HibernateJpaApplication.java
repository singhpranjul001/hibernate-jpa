package com.practice.hibernatejpa;

import com.practice.hibernatejpa.dao.StudentDAO;
import com.practice.hibernatejpa.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
		};
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
