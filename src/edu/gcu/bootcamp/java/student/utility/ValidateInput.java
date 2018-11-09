package edu.gcu.bootcamp.java.student.utility;

import java.util.ArrayList;
import java.util.List;

public class ValidateInput {
	
	public static List<String> validateAddStudentInput(String firstName, String lastName, String address, String city,
			String state, String zip) {
		
		List<String> missingFields = new ArrayList<String>();
		if(firstName == null || firstName == "") {
			missingFields.add("First Name");
		}
		if(lastName == null) {
			missingFields.add("Last Name");
		}
		if(address == null) {
			missingFields.add("Address");
		}
		if(city == null) {
			missingFields.add("City");
		}
		if(state == null) {
			missingFields.add("State");
		}
		if(zip == null) {
			missingFields.add("Zip");
		}
		return missingFields;
		
	}

}
