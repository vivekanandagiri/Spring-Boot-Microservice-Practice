package com.ait.entity;

import com.ait.util.Gender;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "user")
@Data
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String fname;
	private String lname;
	@Column(nullable = false, unique = true)
	private String email;
	@Column(nullable = false, unique = true)
	private Long phone;
	private String password;
	@Enumerated(EnumType.STRING)
	private Gender gender;


}
