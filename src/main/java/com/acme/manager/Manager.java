package com.acme.manager;

import java.util.List;

import com.acme.employee.Employee;

public class Manager {
	
	private String name;
	private String id;
	
	private List<Employee>  managedEmployees;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Employee> getManagedEmployees() {
		return managedEmployees;
	}

	public void setManagedEmployees(List<Employee> managedEmployees) {
		this.managedEmployees = managedEmployees;
	}

}
