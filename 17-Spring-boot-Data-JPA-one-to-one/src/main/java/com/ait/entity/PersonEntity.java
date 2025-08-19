package com.ait.entity;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "persons")

public class PersonEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long personId;
	private String name;
	private String address;
	
	@OneToOne(mappedBy = "personEntity",cascade = CascadeType.ALL)
	private PassportEntity passportEntity;

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public PassportEntity getPassportEntity() {
		return passportEntity;
	}

	public void setPassportEntity(PassportEntity passportEntity) {
		this.passportEntity = passportEntity;
	}

	@Override
	public String toString() {
		return "PersonEntity [personId=" + personId + ", name=" + name + ", address=" + address + ", passportEntity="
				+ passportEntity + "]";
	}

	public PersonEntity(Long personId, String name, String address, PassportEntity passportEntity) {
		super();
		this.personId = personId;
		this.name = name;
		this.address = address;
		this.passportEntity = passportEntity;
	}
	public PersonEntity() {}
}
