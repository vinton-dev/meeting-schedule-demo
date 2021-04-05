package com.calendardemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "category_roles")

public class CategoryRolesEntity {


	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "role_id")
	public long roleId;

	@Column(name = "role_name")
	public String roleName;

}
