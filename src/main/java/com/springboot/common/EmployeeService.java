package com.springboot.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeDAO empDAO;
	

	public List<Employee> retrieveEmployees() {
		
		List<Employee> employees = empDAO.getEMployees();
		return employees;
	}


	public Employee retrieveEmployeeByNo(int empNo) {
		return  empDAO.getEMployeeByNo(empNo);
	}

}
