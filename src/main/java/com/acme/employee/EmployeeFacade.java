package com.acme.employee;

import java.util.List;

import org.springframework.stereotype.Component;

import br.ufrgs.engineering.caching.fmwk.Cacheable;
import br.ufrgs.engineering.caching.fmwk.CachingObserver;
import br.ufrgs.engineering.caching.fmwk.Evict;
@Component
@CachingObserver
public class EmployeeFacade {
	
	@Cacheable(key="employee")
	public List<Employee> getEmployees(){
		return new EmployeeDAO().findAllEmployees();
	}
	
	
	@Cacheable(key="employee")
	public List<Employee> getEmployees(String id){
		return new EmployeeDAO().findAllEmployees();
	}
	
	@Evict(key="employee")
	public void updateEmployee(Employee employee){
		
	}
	
	@Evict(key="employee")
	public void addEmployee(Employee employee){
		 new EmployeeDAO().addEmployee(employee);
		
	}
	
	@Evict(key="employee")
	public void removeEmployee(Employee employee){
		
	}
	
	
	
	public void update(){
		
		
	}
	

}
