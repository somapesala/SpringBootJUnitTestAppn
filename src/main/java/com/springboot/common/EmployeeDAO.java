package com.springboot.common;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAO {

	public List<Employee> getEMployees() {
		List<Employee> employees = Arrays.asList(new Employee(1,"soma",3454525),new Employee(2,"reddy",678858));
		
		return employees;
		
	}

	public Employee getEMployeeByNo(int empNo) {
		Employee e = new Employee();
		e.setEmpNo(empNo);
		e.setName("soma");
		e.setSalary(3454525);
		return e;
	}

}
