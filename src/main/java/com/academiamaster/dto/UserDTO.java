package com.academiamaster.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;

import com.academiamaster.entities.User;

public class UserDTO {

    private Long id;
    private String name;
    private List<String> roles = new ArrayList<>();
    
	public UserDTO(Long id, String name) {
		this.id = id;
		this.name = name;
	}
    
	public UserDTO(User entity) {
		id = entity.getId();
		name = entity.getName();
		for (GrantedAuthority role : entity.getAuthorities()) {
			roles.add(role.getAuthority());
		}
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<String> getRoles() {
		return roles;
	}
}
