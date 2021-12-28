package com.job.springBoot.dataSource.user;

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
@Table(name="user")
public class TableUser {

	

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private Long index;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private String userId; 
	
	private String name; 

	private String password; 

	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private String regNo; 
	
	@Builder
	public TableUser(String userId, String regNo) { 
		this.userId = userId; 
		this.regNo = regNo; 
	}

}