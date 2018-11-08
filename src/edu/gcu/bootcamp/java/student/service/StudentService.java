package edu.gcu.bootcamp.java.student.service;

import edu.gcu.bootcamp.java.student.exception.StudentNotFoundException;
import edu.gcu.bootcamp.java.student.model.Student;

public interface StudentService {
	
	public Student getStudent(int studentId) throws StudentNotFoundException;
	

}
