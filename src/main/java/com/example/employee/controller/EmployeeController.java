package com.example.employee.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.example.employee.repository.EmployeeRepository;
import com.example.employee.exception.ResourceNotFoundException;
import com.example.employee.model.Employee;


@CrossOrigin(origins = "http://localhost:4700")
@RestController
@RequestMapping("api/v1/")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	//get All Employees
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}

	
	//get Employee using Id
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
		Employee employee = employeeRepository.findById(id).orElseThrow(() -> 
							new ResourceNotFoundException("Employee not exist with id :" + id));
		
		return ResponseEntity.ok(employee);
	}
	
	// save employee
	@PostMapping("/saveEmployee")
	public Employee saveEmployee(@RequestBody Employee employee) {
		Employee employee2 = new Employee();
		employee2.setAddress(employee.getAddress());
		employee2.setAge(employee.getAge());
		employee2.setFirstName(employee.getFirstName());
		employee2.setLastName(employee.getLastName());
		employee2.setMobileNumber(employee.getMobileNumber());
		return employeeRepository.save(employee2);
	}
	
	// update Employee
	@PutMapping("/employee/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long Id, @RequestBody Employee employeeDetails){
		Employee employee = employeeRepository.findById(Id)
				.orElseThrow(()-> new ResourceNotFoundException("Employee Not Exist with id : "+Id));
		
		employee.setFirstName(employeeDetails.getFirstName());
		employee.setLastName(employeeDetails.getLastName());
		employee.setAddress(employeeDetails.getAddress());
		employee.setAge(employeeDetails.getAge());
		employee.setMobileNumber(employeeDetails.getMobileNumber());
		
		Employee upEmployee = employeeRepository.save(employee);
		return ResponseEntity.ok(upEmployee);
	}
	
	// delete employee rest 
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		
		employeeRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
