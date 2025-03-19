package com.academiamaster.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Professor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Double salary;
	
	@OneToMany(mappedBy = "professor")
	private List<Product> products = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "master_id")
	private Master master;
	
	public Professor() {
	}

	public Professor(Long id, String name, Double salary, List<Product> products, Master master) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.products = products;
		this.master = master;
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

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Master getMaster() {
		return master;
	}

	public void setMaster(Master master) {
		this.master = master;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, master, name, products, salary);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Professor other = (Professor) obj;
		return Objects.equals(id, other.id) && Objects.equals(master, other.master) && Objects.equals(name, other.name)
				&& Objects.equals(products, other.products) && Objects.equals(salary, other.salary);
	}

}
