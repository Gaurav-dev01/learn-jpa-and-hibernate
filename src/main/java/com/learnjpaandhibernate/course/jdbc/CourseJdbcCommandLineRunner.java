package com.learnjpaandhibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.learnjpaandhibernate.course.Course;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner{

	@Autowired
	private CourseJdbcRepository repository;
	@Override
	public void run(String... args) throws Exception {
		repository.insert(new Course(5,"Learn AWS Now.!","John"));
		repository.insert(new Course(6,"Learn Java","Roy"));
		repository.insert(new Course(7,"Learn React","smith"));
		repository.insert(new Course(8,"Learn Angular","Hary"));
		
		
		repository.deleteById(7);
		
		System.out.println("You are in CourseJdbcCommandLoneRunner class: ");
		System.out.println(repository.findById(6));
		System.out.println(repository.findById(5));
	}

}
