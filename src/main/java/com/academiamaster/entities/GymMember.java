package com.academiamaster.entities;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "gym_member")
public class GymMember {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Double monthly_fee;

	public GymMember() {
	}

	public GymMember(Long id, String name, Double monthly_fee) {
		super();
		this.id = id;
		this.name = name;
		this.monthly_fee = monthly_fee;
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

	public Double getMonthly_fee() {
		return monthly_fee;
	}

	public void setMonthly_fee(Double monthly_fee) {
		this.monthly_fee = monthly_fee;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, monthly_fee, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GymMember other = (GymMember) obj;
		return Objects.equals(id, other.id) && Objects.equals(monthly_fee, other.monthly_fee)
				&& Objects.equals(name, other.name);
	}
	
}
