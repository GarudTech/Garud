package com.garud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.garud.entity.Employee;
import com.garud.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/{empId}")
	public Employee getEmployee(@PathVariable int empId) {
		return employeeService.getEmployee(empId);
	}
	
	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		return employeeService.getEmployees();
	}
	
	@PostMapping("/add")
	public Employee addEmployee(@RequestBody Employee employee) {
		Employee persistedEmployee = employeeService.addEmployee(employee);
		return persistedEmployee;
	}
	
	@GetMapping
	public Employee getEmployeeWithSecondHighestSal() {
		return employeeService.getEmployeeWithSecondHighestSal();
	}
	
	@GetMapping("/sorted-employees")
	public List<Employee> getEmployeesInAsscendingOrder() {
		return employeeService.getEmployeeInAscendingOrder();
	}
}
