package edu.gcu.bootcamp.java.student.dao;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import edu.gcu.bootcamp.java.student.model.Student;

public class StudentDaoImpl implements StudentDao{
	
	private static SessionFactory factory = new Configuration().configure().buildSessionFactory();

	@Override
	public Student getStudentById(long studentId) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Student student = (Student) session.get(Student.class, studentId);
		
		return student;
	}

	@Override
	public Long addStudent(String firstName, String lastName, String address, String city, String state, String zip) {
		
		Transaction transaction = null;
		Long studentId = null;
		
		try(Session session = factory.openSession() ){
			transaction = session.getTransaction();
			transaction.begin();
			Student student = new Student(firstName, lastName, address, city, state, zip);
			studentId = (Long) session.save(student);
			transaction.commit();
		}
		catch(HibernateException exc) {
			transaction.rollback();
		}
		return studentId;
	}

	
	
	

}
