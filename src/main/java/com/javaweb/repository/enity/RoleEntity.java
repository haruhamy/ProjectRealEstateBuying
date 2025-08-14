package com.javaweb.repository.enity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class RoleEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "code", unique = true, nullable = false)
	private String code;
	
	@Column(name = "name", nullable = false)
	private String name;

	@OneToMany(mappedBy = "roleEntity")
	private List<UserRoleEntity> roleUserEntity;
	
	public List<UserRoleEntity> getRoleUserEntity() {
		return roleUserEntity;
	}

	public void setRoleUserEntity(List<UserRoleEntity> roleUserEntity) {
		this.roleUserEntity = roleUserEntity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	
	
	
}
