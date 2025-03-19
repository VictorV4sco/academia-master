package com.academiamaster.entities;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Bills {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Double value;
	
	@ManyToOne
	@JoinColumn(name = "master_id")
	private Master master;
	
	public Bills() {
	}

	public Bills(Long id, String name, Double value, Master master) {
		super();
		this.id = id;
		this.name = name;
		this.value = value;
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

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Master getMaster() {
		return master;
	}

	public void setMaster(Master master) {
		this.master = master;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, master, name, value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bills other = (Bills) obj;
		return Objects.equals(id, other.id) && Objects.equals(master, other.master) && Objects.equals(name, other.name)
				&& Objects.equals(value, other.value);
	}

}
