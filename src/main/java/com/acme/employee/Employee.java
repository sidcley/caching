package com.acme.employee;

import com.acme.manager.Manager;

public class Employee implements Cloneable {
	
	private Integer id;
	private String jobTitle;
	private String name;
	private String ssn;
	
	private Manager manager;
	
	
	public Manager getManager() {
		return manager;
	}
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	public Integer getId() {
		return id;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	
	
	public String getName() {
		return name;
	}
	public String getSsn() {
		return ssn;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", jobTitle=" + jobTitle + ", name="
				+ name + ", ssn=" + ssn + ", manager=" + manager + "]";
	}
	
	

}
