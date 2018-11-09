package edu.gcu.bootcamp.java.student.dao;

import edu.gcu.bootcamp.java.student.model.Student;

public interface StudentDao {
	
	public Student getStudentById(long studentId);
	
	public Long addStudent(String fisrtName, String lastName, String address, String city, String state, String zip);

}
