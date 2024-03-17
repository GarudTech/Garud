package com.garud;

import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.garud.entity.Department;
import com.garud.entity.Employee;
import com.garud.repository.EmployeeRepository;
import com.garud.serviceimpl.EmployeeServiceImpl;

public class EmployeeServiceImplTest {

	
	@InjectMocks
	EmployeeServiceImpl employeeService;
	
	@Mock
	EmployeeRepository employeeRepository;
	
	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	void getEmployeeWithSecondHighestSalary() {
		List<Employee> employees = new ArrayList<>();
		Employee e = new Employee(101, "Ram", 100000, "Tech LEad", LocalDate.of(2023, 02, 19), new Department());
		Employee e2 = new Employee(102, "Seeta", 200000, "Sr. Manager", LocalDate.of(2023, 01, 19), new Department());
		employees.add(e);
		employees.add(e2);
		when(employeeRepository.findAll()).thenReturn(employees);
		Employee result = employeeService.getEmployeeWithSecondHighestSal();
		Assertions.assertEquals(e, result);
	}
}
