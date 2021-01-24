package com.abolkog.springboot.department;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
   
	
	@Autowired
	private DepartmentRepository depRepo;
	
	public List<Department>findAllDepartment(){
		return depRepo.findAll();
	}
	
	public Department getById(String departmentId) {
		return depRepo.findById(departmentId).get();
	}
	
	public Department postDepartment(Department department) {
		return depRepo.insert(department);
	}
	
	public void deleteDepartment(String departmentId) {
		depRepo.deleteById(departmentId);
	}
	public Department updateDepartment(Department department) {
		return depRepo.save(department);
	}
	
}
