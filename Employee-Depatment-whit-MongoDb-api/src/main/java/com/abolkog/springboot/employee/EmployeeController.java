package com.abolkog.springboot.employee;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/employee")
public class EmployeeController {
	@Autowired
	EmployeeService service;
	
	@GetMapping("employee")
	public ResponseEntity<List<Employee>>findAllEmployee(){
		List<Employee>result = service.getAllEmployee();
		return new ResponseEntity<>(result,HttpStatus.OK);
	}
	@GetMapping("/{employeeid}")
	public ResponseEntity<Employee >findEmployeeById(@PathVariable String employeeid){
		Employee result = service.getEmployeeById(employeeid);
		return new ResponseEntity<>(result,HttpStatus.OK);
	}
	@PostMapping("employee")
	public ResponseEntity<Employee>insertDepartment(@Valid@RequestBody Employee employee){
		Employee result = service.postEmplyee(employee);
		return new ResponseEntity<>(result,HttpStatus.CREATED);
	}
	@DeleteMapping("employee/{employeeid}")
	public ResponseEntity<Void>deleteDepartment(@PathVariable String employeeid){
		service.deleteEmployee(employeeid);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	@PutMapping("employee/{employeeid}")
	public ResponseEntity<Employee>updateEmployee(@PathVariable String employeeid,@Valid@RequestBody Employee employee){
		Optional<Employee> employeeData = Optional.ofNullable(service.getEmployeeById(employeeid));
		 
	    if (employeeData.isPresent()) {
	      Employee _employee = employeeData.get();
	      _employee.setFirstName(employee.getFirstName());
	      _employee.setLastName(employee.getLastName());
	      _employee.setDepartment(employee.getDepartment());
	      _employee.setDateOfJoining(employee.getDateOfJoining());
	      _employee.setPhotoFileName(employee.getPhotoFileName());
	      return new ResponseEntity<>(service.updateEmployee(_employee), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
}
