package com.academiamaster.entities;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Gym {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Double gross_profit;
	private Double net_profit;
	
	@OneToMany(mappedBy = "gym", fetch = FetchType.EAGER)
	private Set<GymMember> gymMembers = new HashSet<>();
	
	public Gym() {
	}

	public Gym(Long id, Double gross_profit, Double net_profit) {
		super();
		this.id = id;
		this.gross_profit = gross_profit;
		this.net_profit = net_profit;
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

	public Set<GymMember> getGymMembers() {
		return gymMembers;
	}

	public void setGymMembers(Set<GymMember> gymMembers) {
		this.gymMembers = gymMembers;
	}

	@Override
	public int hashCode() {
		return Objects.hash(gross_profit, gymMembers, id, net_profit);
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
		return Objects.equals(gross_profit, other.gross_profit) && Objects.equals(gymMembers, other.gymMembers)
				&& Objects.equals(id, other.id) && Objects.equals(net_profit, other.net_profit);
	}
	
}
