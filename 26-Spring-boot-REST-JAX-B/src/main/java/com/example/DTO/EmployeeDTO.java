package com.example.DTO;

import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "employee")
public class EmployeeDTO {
	
	private int id;
	private String name;
	private double salary;
	private List<String> skills;
	
	@XmlElement
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@XmlElement
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@XmlElement
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@XmlElementWrapper(name = "skills")
	@XmlElement
	public List<String> getSkills() {
		return skills;
	}
	public void setSkills(List<String> skills) {
		this.skills = skills;
	}
	public EmployeeDTO(int id, String name, double salary, List<String> skills) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.skills = skills;
	}
	//Zero parameter
	public EmployeeDTO() {
	}
	@Override
	public String toString() {
		return "EmployeeDTO [id=" + id + ", name=" + name + ", salary=" + salary + ", skills=" + skills + "]";
	}
	
	

	
	
	

}
