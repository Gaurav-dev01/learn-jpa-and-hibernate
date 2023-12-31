package com.learnjpaandhibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.learnjpaandhibernate.course.Course;

@Repository
public class CourseJdbcRepository {

	@Autowired
	private JdbcTemplate springJdbcTemplate;

	private static String INSERT_QUERY = "INSERT INTO COURSE (id,name,author) \r\n" + "VALUES (?,?,?)";

	private static String DELETE_QUERY = "DELETE FROM COURSE WHERE id = ?";

	private static String SELECT_QUERY = "SELECT * FROM COURSE WHERE id = ?";

	public void insert(Course course) {
		springJdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
	}

	public void deleteById(long id) {
		springJdbcTemplate.update(DELETE_QUERY, id);

	}

	public Course findById(long id) {
		return springJdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), id);
	}

}
