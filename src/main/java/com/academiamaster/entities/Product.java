package com.academiamaster.entities;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String type;
	private Double price;
	private Integer amount;
	private LocalDateTime date;
	private Professor professor_name;
	
	public Product() {
	}

	public Product(Long id, String name, String type, Double price, Integer amount, LocalDateTime date,
			Professor professor_name) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.price = price;
		this.amount = amount;
		this.date = date;
		this.professor_name = professor_name;
	}

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Professor getProfessor_name() {
		return professor_name;
	}

	public void setProfessor_name(Professor professor_name) {
		this.professor_name = professor_name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, date, id, name, price, professor_name, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(amount, other.amount) && Objects.equals(date, other.date) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(price, other.price)
				&& Objects.equals(professor_name, other.professor_name) && Objects.equals(type, other.type);
	}
	
}
