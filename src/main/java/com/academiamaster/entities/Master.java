package com.academiamaster.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Master {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Double gross_profit;
	private Double net_profit;
	
	@OneToMany(mappedBy = "master")
	private List<Bills> bills = new ArrayList<>();
	
	@OneToMany(mappedBy = "master")
	private List<Product> products = new ArrayList<>();
	
	@OneToMany(mappedBy = "master")
	private List<Professor> professors = new ArrayList<>();
	
	public Master() {
	}

	public Master(Long id, Double gross_profit, Double net_profit, List<Bills> bills, List<Product> products,
			List<Professor> professors) {
		super();
		this.id = id;
		this.gross_profit = gross_profit;
		this.net_profit = net_profit;
		this.bills = bills;
		this.products = products;
		this.professors = professors;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getGross_profit() {
		return gross_profit;
	}

	public void setGross_profit(Double gross_profit) {
		this.gross_profit = gross_profit;
	}

	public Double getNet_profit() {
		return net_profit;
	}

	public void setNet_profit(Double net_profit) {
		this.net_profit = net_profit;
	}

	public List<Bills> getBills() {
		return bills;
	}

	public void setBills(List<Bills> bills) {
		this.bills = bills;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<Professor> getProfessors() {
		return professors;
	}

	public void setProfessors(List<Professor> professors) {
		this.professors = professors;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bills, gross_profit, id, net_profit, products, professors);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Master other = (Master) obj;
		return Objects.equals(bills, other.bills) && Objects.equals(gross_profit, other.gross_profit)
				&& Objects.equals(id, other.id) && Objects.equals(net_profit, other.net_profit)
				&& Objects.equals(products, other.products) && Objects.equals(professors, other.professors);
	}

}
