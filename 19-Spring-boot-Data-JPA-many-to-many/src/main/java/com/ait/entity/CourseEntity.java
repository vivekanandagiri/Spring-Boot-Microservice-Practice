package com.ait.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode; // Import this
import lombok.ToString;

@Entity
@Table(name = "course")
@Data
@ToString(exclude = "students")
public class CourseEntity {
	@Id
	@GeneratedValue
	private Long id;
	private String title;
	
	@ManyToMany(mappedBy = "course",fetch = FetchType.EAGER)
	 
	@EqualsAndHashCode.Exclude 
	private Set<StudentEntity>students=new HashSet<>();
}