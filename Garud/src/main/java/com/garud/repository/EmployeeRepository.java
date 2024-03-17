package com.garud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.garud.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	Employee findEmployeeByEmpId(int empId);
}
