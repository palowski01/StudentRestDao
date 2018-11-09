package edu.gcu.bootcamp.java.student.service;

import edu.gcu.bootcamp.java.student.exception.StudentNotAddedException;
import edu.gcu.bootcamp.java.student.exception.StudentNotFoundException;
import edu.gcu.bootcamp.java.student.model.Student;

public interface StudentService {
	
	public Student getStudent(long id) throws StudentNotFoundException;
	
	public Long createStudent(String firstName, String lastName, String address, String city, String state, String zip) throws StudentNotAddedException;
	
}
