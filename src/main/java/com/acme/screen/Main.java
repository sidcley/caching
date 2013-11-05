package com.acme.screen;

import java.util.Map;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import br.ufrgs.engineering.caching.fmwk.CachingObserver;

import com.acme.employee.EmployeeController;

public class Main {
	
	
	public static void main(String[] args) {
		 AnnotationConfigApplicationContext context  =new  AnnotationConfigApplicationContext();
		 context.scan("com","br");
		
		 context.refresh();
		 Map<String,Object> beans = context.getBeansWithAnnotation(CachingObserver.class);
		 EmployeeController controller =  context.getBean(EmployeeController.class);
		
		 
		 
		 
		 controller.listEmployees();
		 controller.listEmployees();
		 controller.addEmployee();
		 controller.listEmployees();
		 controller.listEmployees();
		 context.close();
		
	}

}
