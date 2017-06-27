package com.springboot.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ComponentScan
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value={"/getEmployees"})
	public List<Employee> retrieveEmployees() {
		 List<Employee> retrieveEmployees = employeeService.retrieveEmployees();
		 
		 for (Employee employee : retrieveEmployees) {
			System.out.println(employee);
		}	
		 
	return retrieveEmployees;
	}
	
	@GetMapping("/employee/details/{empNo}")
	public Employee retrieveDetailsForEmployee(@PathVariable int empNo) {
		 Employee employee = employeeService.retrieveEmployeeByNo(empNo);
		 System.out.println(employee);
		 
		 return employee;
	}
	
	@PostMapping("/saveEmployee/{data}")
	public int saveEmployee(@RequestBody  Employee employee,@PathVariable String data){
		
		System.out.println(employee);
		System.out.println("data is :"+data);
		
		return employee.getEmpNo();
	}
		

}
