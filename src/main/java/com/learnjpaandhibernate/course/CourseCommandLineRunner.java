package com.learnjpaandhibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.learnjpaandhibernate.course.springDataJpa.CourseSpringDataJpaRepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

	// @Autowired
	// private CourseJpaRepository repository;

	@Autowired
	private CourseSpringDataJpaRepository repository;

//	INSERT data into table
	@Override
	public void run(String... args) throws Exception {
		repository.save(new Course(1, "Learn JAVA", "John"));
		repository.save(new Course(2, "Learn C", "Roy"));
		repository.save(new Course(3, "Learn React", "smith"));
		repository.save(new Course(4, "Learn Angular", "Hary"));

//		DELETE by ID
		System.out.println("\nDELETE by ID:\n");
		repository.deleteById(4l);

		System.out.println("\nYou are in class: CourseCommandLineRunner\n");
//		DISPLAY data by ID
		System.out.println("\nDisplay Data by ID:\n");
		System.out.println(repository.findById(1l));
		System.out.println(repository.findById(3l));

//		DISPLAY ALL data from table
		System.out.println("\nDisplay all Data from table:\n");
		System.out.println("\nFindAll() method: " + repository.findAll());
	
//		FindByAuthor
		System.out.println("\nDisplay all Data by Autor:\n");
		System.out.println("\nFind by author name 'Roy': "+ repository.findByAuthor("Roy"));
		System.out.println("\nFind by author name just blank: "+ repository.findByAuthor(""));
	
//		FindByName
		System.out.println("Find by name: "+repository.findByName("Learn React"));
		
//		Exist by ID
		System.out.println("\nExist by ID: "+repository.existsById(2l));
		
//		count total number of records
		System.out.println("\ncount total number of records: "+repository.count());
		
		
	}

}
