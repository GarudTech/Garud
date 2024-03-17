package com.garud.serviceimpl;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.garud.entity.Employee;
import com.garud.repository.EmployeeRepository;
import com.garud.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee getEmployee(int empId) {
		return employeeRepository.findEmployeeByEmpId(empId);
	}

	@Override
	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployeeWithSecondHighestSal() {
		List<Employee> employees = employeeRepository.findAll();
		Optional<Employee> optionalEmployee = employees.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
				.skip(1).findFirst();
		Employee employee = null;
		if(optionalEmployee.isPresent()) {
			employee = optionalEmployee.get();
		}
		return employee;
	}

	@Override
	public List<Employee> getEmployeeInAscendingOrder() {
		List<Employee> employees = employeeRepository.findAll().stream().sorted(Comparator.comparing(Employee::getEmpName)
				.thenComparing(Employee::getSalary)).collect(Collectors.toList());
		return employees;
	}

}
