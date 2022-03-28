package com.example.demo;

import com.example.demo.models.Student;
import com.example.demo.repository.StudentRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}

//	@Autowired
//	private StudentRepos studentRepos;
//	@Override
//	public void run(String... args) throws Exception {
//		Student student=new Student();
//		student.setName("alisina");
//		student.setLastName("sadat");
//		student.setEmail("alisina@12");
//		studentRepos.save(student);
//
//		Student student1=new Student();
//		student.setName("ali");
//		student.setLastName("sadat2");
//		student.setEmail("alisina@1222");
//		studentRepos.save(student1);
//	}
}
