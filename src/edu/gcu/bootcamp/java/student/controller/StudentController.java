package edu.gcu.bootcamp.java.student.controller;



import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

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

import edu.gcu.bootcamp.java.student.exception.StudentNotAddedException;
import edu.gcu.bootcamp.java.student.exception.StudentNotFoundException;
import edu.gcu.bootcamp.java.student.model.Student;
import edu.gcu.bootcamp.java.student.service.StudentService;
import edu.gcu.bootcamp.java.student.service.StudentServiceImpl;
import edu.gcu.bootcamp.java.student.utility.ValidateInput;

@Path("student")
public class StudentController {
	
	@Path("get/{id}")
	@GET
	@Produces("application/json")
	public Response getStudent(@PathParam("id") long id) {
		
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
	
	@Path("students/")
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
//	@Produces("application/json")
	public Response addStudent(@FormParam("firstName") String firstName, 
			@FormParam("lastName") String lastName, @FormParam("address") String address, @FormParam("city") String city,
			@FormParam("state") String state, @FormParam("zip") String zip) {
		
		List<String> missingFields = ValidateInput.validateAddStudentInput(firstName, lastName, address, city, state, zip);
		
		StringBuilder messageBuilder = new StringBuilder("Please include the following fields: ");
		if (missingFields.size() != 0) {
			for(String field : missingFields) {
				messageBuilder.append(field).append(", ");
			}
			String message = messageBuilder.substring(0, messageBuilder.lastIndexOf(", "));
			return Response.status(400).entity(message).build();
		}
		
		final String baseUri = "edu.gcu.bootcamp.java.student";
		
		StudentService service = new StudentServiceImpl();
		
		try {
			Long studentId = service.createStudent(firstName, lastName, address, city, state, zip);
			return Response.created(new URI(baseUri + "/" + studentId)).build();
		}
		catch (StudentNotAddedException exc) {
			return Response.status(500).entity(exc.getMessage()).build();
		} 
		catch (URISyntaxException exc) {
			return Response.status(500).entity(exc.getMessage()).build();
		}

	}
}
