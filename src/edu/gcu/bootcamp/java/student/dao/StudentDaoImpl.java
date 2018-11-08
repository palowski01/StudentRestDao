package edu.gcu.bootcamp.java.student.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import edu.gcu.bootcamp.java.student.model.Student;

public class StudentDaoImpl implements StudentDao{

	@Override
	public Student getStudentById(int studentId) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Student student = (Student) session.get(Student.class, studentId);
		
		return student;
	}

	
	
	

}
