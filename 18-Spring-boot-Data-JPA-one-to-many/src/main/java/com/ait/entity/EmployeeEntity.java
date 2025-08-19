package com.ait.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "employee")
@Data
public class EmployeeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@ManyToOne
	@JoinColumn(name = "department_id")
	private DepartmentEntity department;
	@Override
	public String toString() {
		return "EmployeeEntity [id=" + id + ", name=" + name + "]";
	}
	

}
