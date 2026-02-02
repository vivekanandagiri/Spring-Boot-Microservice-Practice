package com.example.entity;

import com.example.util.Gender;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "employee")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@XmlRootElement
public class EmployeeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@XmlElement
	private Long id;
	@Column(name = "password", nullable = false)
	@XmlElement
	private String password;
	@Column(name = "name", nullable = false)
	@XmlElement
	private String name;
	@Column(name = "email", nullable = false, unique = true, length = 100)
	@XmlElement
	private String email;
	@XmlElement
	private Long phone;
	@XmlElement
	private Double salary;
	@XmlElement
	private String jobTitle;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "gender", length = 50)
	@XmlElement
	private Gender gender;
	@Column(name = "city", length = 50)
	@XmlElement
	private String city;
}


