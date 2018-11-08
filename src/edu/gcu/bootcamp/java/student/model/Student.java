package edu.gcu.bootcamp.java.student.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name="student")
public class Student {
	
	@Column (name = "first_name")
	private String firstName;
	
	@Column (name = "last_name")
	private String lastName;
	
	@Id
	@Column (name = "student_id")
	private int studentId;
	
	@Column (name = "address")
	private String address;
	
	@Column (name = "city")
	private String city;
	
	@Column (name = "state")
	private String state;
	
	@Column (name = "zip")
	private String zip;
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public String getZip() {
		return zip;
	}
	
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public int getStudentId() {
		return studentId;
	}
	
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	

}
