package com.academiamaster.entities;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Table
@Entity
public class Expenses {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String type;
	private String name;
	private Double value;
	private LocalDateTime moment;
	
	@ManyToOne()
	@JoinColumn(name = "expenses_id")
	private Gym gym;
	
	public Expenses() {
	}

	public Expenses(Long id, String type, String name, Double value, LocalDateTime moment, Gym gym) {
		super();
		this.id = id;
		this.type = type;
		this.name = name;
		this.value = value;
		this.moment = moment;
		this.gym = gym;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public LocalDateTime getMoment() {
		return moment;
	}

	public void setMoment(LocalDateTime moment) {
		this.moment = moment;
	}

	public Gym getGym() {
		return gym;
	}

	public void setGym(Gym gym) {
		this.gym = gym;
	}

	@Override
	public int hashCode() {
		return Objects.hash(gym, id, moment, name, type, value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Expenses other = (Expenses) obj;
		return Objects.equals(gym, other.gym) && Objects.equals(id, other.id) && Objects.equals(moment, other.moment)
				&& Objects.equals(name, other.name) && Objects.equals(type, other.type)
				&& Objects.equals(value, other.value);
	}
}

