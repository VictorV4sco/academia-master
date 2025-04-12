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
	private String payerName;
	private String type;
	private Double value;
	private LocalDateTime paymentMoment;
	
	public Payments() {
	}

	public Payments(Long id, String payerName, String type, Double value, LocalDateTime paymentMoment) {
		this.id = id;
		this.payerName = payerName;
		this.type = type;
		this.value = value;
		this.paymentMoment = paymentMoment;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPayerName() {
		return payerName;
	}

	public void setPayerName(String payerName) {
		this.payerName = payerName;
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

	public LocalDateTime getPaymentMoment() {
		return paymentMoment;
	}

	public void setPaymentMoment(LocalDateTime paymentMoment) {
		this.paymentMoment = paymentMoment;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, payerName, paymentMoment, type, value);
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
		return Objects.equals(id, other.id) && Objects.equals(payerName, other.payerName)
				&& Objects.equals(paymentMoment, other.paymentMoment) && Objects.equals(type, other.type)
				&& Objects.equals(value, other.value);
	}
	
}
