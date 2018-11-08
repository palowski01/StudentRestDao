package edu.gcu.bootcamp.java.student.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.json.JSONObject;

import edu.gcu.bootcamp.java.student.exception.StudentNotFoundException;
import edu.gcu.bootcamp.java.student.model.Student;
import edu.gcu.bootcamp.java.student.service.StudentService;
import edu.gcu.bootcamp.java.student.service.StudentServiceImpl;

@Path("student")
public class StudentController {
	
	@Path("get/{id}")
	@GET
	@Produces("application/json")
	public Response getStudent(@PathParam("id") int id) {
		
		StudentService service = new StudentServiceImpl();
		try {
			Student student = service.getStudent(id);
			JSONObject json = new JSONObject();
			json.put("firstName", student.getFirstName());
			json.put("lastName", student.getLastName());
			json.put("address", student.getAddress());
			json.put("city", student.getCity());
			json.put("State", student.getState());
			json.put("zip",  student.getZip());
			
			return Response.status(200).entity(json.toString()).build();
		} 
		catch (StudentNotFoundException e) {
			
			return Response.status(404).entity(e.getMessage()).build();
		}
	}
	
	@Path("add/")
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response addStudent(@FormParam("studentId") int studentId, @FormParam("firstName") String firstName, 
			@FormParam("lastname") String lastName, @FormParam("address") String address, @FormParam("city") String city,
			@FormParam("state") String state, @FormParam("zip") String zip) {
		
		Student student = new Student();
		student.setStudentId(studentId);
		student.setAddress(address);
		student.setCity(city);
		student.setFirstName(firstName);
		student.setLastName(lastName);
		student.setState(state);
		student.setZip(zip);
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(student);
		session.getTransaction().commit();
		
		String result = "Product created : " + student;
		return Response.status(201).entity(result).build();
	}
}
