package com.ait.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "passports")

public class PassportEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long passportId;
	private String passportNo;
	private LocalDate expiryDate;
	
	@OneToOne
	@JoinColumn(name = "person_id")
	private PersonEntity personEntity;

	public Long getPassportId() {
		return passportId;
	}

	public void setPassportId(Long passportId) {
		this.passportId = passportId;
	}

	public String getPassportNo() {
		return passportNo;
	}

	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public PersonEntity getPersonEntity() {
		return personEntity;
	}

	public void setPersonEntity(PersonEntity personEntity) {
		this.personEntity = personEntity;
	}

	@Override
	public String toString() {
		return "PassportEntity [passportId=" + passportId + ", passportNo=" + passportNo + ", expiryDate=" + expiryDate
				+ "]";
	}

	public PassportEntity(Long passportId, String passportNo, LocalDate expiryDate, PersonEntity personEntity) {
		this.passportId = passportId;
		this.passportNo = passportNo;
		this.expiryDate = expiryDate;
		this.personEntity = personEntity;
	}
	public PassportEntity() {}
	
	

}
