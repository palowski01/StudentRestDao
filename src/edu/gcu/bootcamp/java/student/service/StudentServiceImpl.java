package edu.gcu.bootcamp.java.student.service;

import edu.gcu.bootcamp.java.student.dao.StudentDao;
import edu.gcu.bootcamp.java.student.dao.StudentDaoImpl;
import edu.gcu.bootcamp.java.student.exception.StudentNotAddedException;
import edu.gcu.bootcamp.java.student.exception.StudentNotFoundException;
import edu.gcu.bootcamp.java.student.model.Student;

public class StudentServiceImpl implements StudentService {

	@Override
	public Student getStudent(long studentId) throws StudentNotFoundException{
		
		StudentDao dao = new StudentDaoImpl();
		Student student = dao.getStudentById(studentId);
		
		if (student == null) {
			// throw exception
			throw new StudentNotFoundException("No student found for id " + studentId);
		}
		else {
			return student;
		}

	}

	@Override
	public Long createStudent(String firstName, String lastName, String address, String city, String state, String zip) 
			throws StudentNotAddedException {
		
		StudentDao dao = new StudentDaoImpl();
		
		Long studentId = dao.addStudent(firstName, lastName, address, city, state, zip);
		if (studentId == null) {
			throw new StudentNotAddedException("student not added");
		}
		
		return studentId;
	}


}
