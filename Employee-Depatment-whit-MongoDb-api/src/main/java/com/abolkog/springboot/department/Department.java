package com.abolkog.springboot.department;



import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "dbo.Department")
public class Department {

	
	@Id
	private String departmentId;
	
	@NotNull(message = "department required!!")
	private String departmentName;


	public Department(String departmentId, @NotNull(message = "department required!!") String departmentName) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
	}


	


	public String getDepartmentId() {
		return departmentId;
	}


	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}


	public String getDepartmentName() {
		return departmentName;
	}


	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	
	
}
