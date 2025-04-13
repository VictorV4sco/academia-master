package com.academiamaster.entities;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Gym {

	@Id
	private Long id = 1L;
	private Double gross_profit;
	private Double net_profit;
	private Integer month;
	
	public Gym() {
	}
	
	public Gym(Long id, Double gross_profit, Double net_profit, Integer month) {
		this.id = id;
		this.gross_profit = gross_profit;
		this.net_profit = net_profit;
		this.month = month;
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

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	@Override
	public int hashCode() {
		return Objects.hash(gross_profit, id, month, net_profit);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Gym other = (Gym) obj;
		return Objects.equals(gross_profit, other.gross_profit) && Objects.equals(id, other.id)
				&& Objects.equals(month, other.month) && Objects.equals(net_profit, other.net_profit);
	}

}
