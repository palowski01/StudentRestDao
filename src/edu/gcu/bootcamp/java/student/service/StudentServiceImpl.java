package edu.gcu.bootcamp.java.student.service;

import edu.gcu.bootcamp.java.student.dao.StudentDao;
import edu.gcu.bootcamp.java.student.dao.StudentDaoImpl;
import edu.gcu.bootcamp.java.student.exception.StudentNotFoundException;
import edu.gcu.bootcamp.java.student.model.Student;

public class StudentServiceImpl implements StudentService {

	@Override
	public Student getStudent(int studentId) throws StudentNotFoundException{
		
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


}
