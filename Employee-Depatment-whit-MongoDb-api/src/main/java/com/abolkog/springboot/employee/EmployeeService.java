package com.abolkog.springboot.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	
	@Autowired
	private EmployeeRepository empRepo;
	
	public List<Employee>getAllEmployee(){
		return empRepo.findAll();
	}
	
	public Employee getEmployeeById(String employeeId) {
		return empRepo.findById(employeeId).get();
	}
	public Employee postEmplyee(Employee employee) {
		return empRepo.insert(employee);
	}
	public void deleteEmployee(String employeeId) {
		empRepo.deleteById(employeeId);
	}
	public Employee updateEmployee(Employee employee) {
		return empRepo.save(employee);
	}
	
}
