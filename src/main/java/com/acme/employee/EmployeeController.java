package com.acme.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class EmployeeController {
	
	
	@Autowired
	private EmployeeFacade employeeFacade;
	
	public void listEmployees(){
		Long start = System.currentTimeMillis();
		List<Employee> employees= employeeFacade.getEmployees();
		for (Employee employee : employees) {
			System.out.println("employee: "+employee);
		}
		long tot = System.currentTimeMillis() - start;
		System.out.println("total time:"+tot);
	}

	
	
	public void addEmployee(){
		Employee employee = new Employee();
		employee.setId((int)Math.round(Math.random()*100));
		employee.setJobTitle("manager");
		employee.setName("Carlos");
		employeeFacade.addEmployee(employee);
	}
}
