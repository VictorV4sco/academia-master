package com.academiamaster.entities;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Payments {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String payer_name;
	private String type;
	private Double value;
	private LocalDateTime paymente_moment;
	
	public Payments() {
	}

	public Payments(Long id, String payer_name, String type, Double value, LocalDateTime paymente_moment) {
		super();
		this.id = id;
		this.payer_name = payer_name;
		this.type = type;
		this.value = value;
		this.paymente_moment = paymente_moment;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPayer_name() {
		return payer_name;
	}

	public void setPayer_name(String payer_name) {
		this.payer_name = payer_name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public LocalDateTime getPaymente_moment() {
		return paymente_moment;
	}

	public void setPaymente_moment(LocalDateTime paymente_moment) {
		this.paymente_moment = paymente_moment;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, payer_name, paymente_moment, type, value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payments other = (Payments) obj;
		return Objects.equals(id, other.id) && Objects.equals(payer_name, other.payer_name)
				&& Objects.equals(paymente_moment, other.paymente_moment) && Objects.equals(type, other.type)
				&& Objects.equals(value, other.value);
	}
	
}
