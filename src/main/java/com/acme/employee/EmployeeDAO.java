package com.acme.employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.acme.manager.Manager;

public class EmployeeDAO {
	static List<Employee> database = new ArrayList<Employee>();

	static {
		Manager manager = new Manager();
		manager.setId("-1");
		manager.setName("Big boss");
		for (int i = 0; i < 10; i++) {
			Employee employee = new Employee();
			employee.setId(i);
			employee.setName("bob"+i);
			employee.setJobTitle("waiter");
			database.add(employee);
			
		}
		manager.setManagedEmployees(database);
	}

	public List<Employee> findAllEmployees() {
		
		System.out.println("this is something costly...");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return (List<Employee>) ((ArrayList<Employee>)database).clone();

	}
	 
	
	public void addEmployee(Employee employee){
		database.add(employee);
	}
	
	
	

}
