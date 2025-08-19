package com.ait.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "categories")
@Data
public class CategoryEntity {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	
	@OneToMany(mappedBy = "category",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@ToString.Exclude // Prevents recursive toString() call
    @EqualsAndHashCode.Exclude // Prevents recursive equals() and hashCode() calls
    private List<ProductEntity>products=new ArrayList<>();
	
	
	
	

}
