package com.ait.entity;

import java.time.LocalDate;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "product")
@Data
public class ProductEntity {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String price;
	private String model;
	private LocalDate mfd;
	private	int warranty;
	

}
