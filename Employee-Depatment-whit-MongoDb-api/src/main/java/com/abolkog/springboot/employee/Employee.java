package com.abolkog.springboot.employee;



import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "dbo.Employee")
public class Employee {

	
	@Id
	private String employeeId;
	
	@NotNull(message = "required")
	private String firstName;
	@NotNull(message = "required")
	private String lastName;
	
	@NotNull(message = "required")
	private String department;
	@NotNull(message = "required")
	private String dateOfJoining;
	@NotNull(message = "required")
	private String photoFileName;

	

	



	public Employee(String employeeId, String firstName, String lastName, String department,
			@NotNull(message = "required") String dateOfJoining, String photoFileName) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
		this.dateOfJoining = dateOfJoining;
		this.photoFileName = photoFileName;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
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

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public String getPhotoFileName() {
		return photoFileName;
	}

	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}

	

	
	
}
