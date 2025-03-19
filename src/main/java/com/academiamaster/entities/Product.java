package com.academiamaster.entities;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String type;
	private Double price;
	private Integer amount;
	private LocalDateTime moment;
	
	@ManyToOne
	@JoinColumn(name = "professor_id")
	private Professor professor;
	
	public Product() {
	}

	public Product(Long id, String name, String type, Double price, Integer amount, LocalDateTime moment,
			Professor professor) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.price = price;
		this.amount = amount;
		this.moment = moment;
		this.professor = professor;
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

	public LocalDateTime getMoment() {
		return moment;
	}

	public void setMoment(LocalDateTime moment) {
		this.moment = moment;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, id, moment, name, price, professor, type);
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
		return Objects.equals(amount, other.amount) && Objects.equals(id, other.id)
				&& Objects.equals(moment, other.moment) && Objects.equals(name, other.name)
				&& Objects.equals(price, other.price) && Objects.equals(professor, other.professor)
				&& Objects.equals(type, other.type);
	}
}
