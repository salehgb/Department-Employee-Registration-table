package com.abolkog.springboot.department;

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

import com.abolkog.springboot.employee.Employee;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/department")
public class DepartmentController {

	
	@Autowired
	DepartmentService service;
	
	@GetMapping("department")
	public ResponseEntity<List<Department>>findAllDepartment(){
		List<Department>result = service.findAllDepartment();
		return new ResponseEntity<>(result,HttpStatus.OK);
	}
	@GetMapping("/{departmentid}")
	public ResponseEntity<Department >findDepartmentById(@PathVariable String departmentid){
		Department result = service.getById(departmentid);
		return new ResponseEntity<>(result,HttpStatus.OK);
	}
	@PostMapping("department")
	public ResponseEntity<Department>insertDepartment(@Valid@RequestBody Department department){
		Department result = service.postDepartment(department);
		return new ResponseEntity<>(result,HttpStatus.CREATED);
	}
	@DeleteMapping("department/{departmentid}")
	public ResponseEntity<Void>deleteDepartment(@PathVariable String departmentid){
		service.deleteDepartment(departmentid);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	@PutMapping("department/{departmentid}")
	public ResponseEntity<Department>updateDepartment(@PathVariable String departmentid,@Valid@RequestBody Department department){
		Optional<Department> departmentData = Optional.ofNullable(service.getById(departmentid));
		 
	    if (departmentData.isPresent()) {
	      Department _dep = departmentData.get();
	     _dep.setDepartmentName(department.getDepartmentName());
	      return new ResponseEntity<>(service.updateDepartment(_dep), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
}
}