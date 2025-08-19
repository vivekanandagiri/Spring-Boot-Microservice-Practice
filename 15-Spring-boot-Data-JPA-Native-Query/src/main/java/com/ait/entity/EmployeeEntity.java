package com.ait.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Employee")
public class EmployeeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String dept;
	private long contactNo;
	private int salary;
	private String address;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public long getContactNo() {
		return contactNo;
	}
	public void setContactNo(long i) {
		this.contactNo = i;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int i) {
		this.salary = i;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "EmployeeEntity [id=" + id + ", name=" + name + ", dept=" + dept + ", contactNo=" + contactNo
				+ ", salary=" + salary + ", address=" + address + "]";
	}
	
}
