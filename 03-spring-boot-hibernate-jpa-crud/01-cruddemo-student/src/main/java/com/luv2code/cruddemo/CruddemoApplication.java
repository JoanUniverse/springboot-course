package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
//			createStudent(studentDAO);

//			createMultipleStudents(studentDAO);
			readStudent(studentDAO);
		};
	}

	private void readStudent(StudentDAO studentDAO) {
		Student tempStudent = new Student("Daffy", "Duck", "duck@gmail.com");

		studentDAO.save(tempStudent);

		int id = tempStudent.getId();
		System.out.println("ID " + id);

		Student myStudent = studentDAO.findById(id);
		System.out.println(myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		Student tempStudent1 = new Student("Jo", "Mateix", "joan@gmail.com");
		Student tempStudent2 = new Student("Marc", "Public", "marc@gmail.com");
		Student tempStudent3 = new Student("Bonita", "Isla", "bonita@gmail.com");

		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating student...");
		Student tempStudent = new Student("Jo", "Mateix", "joan@gmail.com");

		System.out.println("Saving student...");
		studentDAO.save(tempStudent);

		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}
}
