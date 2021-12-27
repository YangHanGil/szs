package com.job.springBoot.dataSource.permission;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name="permission")
public class TablePermission {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private Long index;

	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private String name; 

	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private String regNo; 
	
	@Builder
	public TablePermission(String name, String regNo) { 
		this.name = name;
		this.regNo = regNo;
	}

}
