package com.yash.Inventory.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Name Cannot be Null")
    private String name;

    @NotNull(message = "Expiry date cannot be null")
    private LocalDate expiryDate;

    @NotNull(message = "Price cannot be null")
    @Positive(message = "Price must be positive")
    private BigDecimal price;
    @NotNull(message = "Quantity cannot be null")
    @Positive(message = "Quantity must be positive")
    private int quantity;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(Long id, @NotNull(message = "Name Cannot be Null") String name,
			@NotNull(message = "Expiry date cannot be null") LocalDate expiryDate,
			@NotNull(message = "Price cannot be null") @Positive(message = "Price must be positive") BigDecimal price,
			@NotNull(message = "Quantity cannot be null") @Positive(message = "Quantity must be positive") int quantity) {
		super();
		this.id = id;
		this.name = name;
		this.expiryDate = expiryDate;
		this.price = price;
		this.quantity = quantity;
	}
    
}