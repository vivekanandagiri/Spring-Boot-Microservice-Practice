package com.ait.dto;

import java.time.LocalDate;

import com.ait.util.ProductType;

import lombok.Data;

@Data
public class ProductDTO {
	public Long id;
	public String name;
	public String brand;
	public int warranty;
	public Double price;
	public int quantity;
	public LocalDate mfd;
	public ProductType type;

}
