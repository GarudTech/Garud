package com.garud.service;

import java.util.List;

import com.garud.entity.Employee;

public interface EmployeeService {

	Employee getEmployee(int empId);
	List<Employee> getEmployees();
	Employee addEmployee(Employee employee);
	Employee getEmployeeWithSecondHighestSal();
	List<Employee> getEmployeeInAscendingOrder();
}
