package com.ait.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
	private Double price;
	@ManyToOne(fetch = FetchType.EAGER)
	private CategoryEntity category;
	@Override
	public String toString() {
		return "ProductEntity [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
	

}
