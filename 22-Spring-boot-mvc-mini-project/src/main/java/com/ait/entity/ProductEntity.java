package com.ait.entity;

import java.time.LocalDate;

import com.ait.util.ProductType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "product")
@Data
public class ProductEntity {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String brand;
	private int warranty;
	private Double price;
	private int quantity;
	private LocalDate mfd;
	@Enumerated(EnumType.STRING)
	private ProductType type;
	

}
