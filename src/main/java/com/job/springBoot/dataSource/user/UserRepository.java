package com.job.springBoot.dataSource.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.job.springBoot.login.LoginVo;
import com.job.springBoot.login.UserVo;

@Repository
public interface UserRepository extends JpaRepository<TableUser, Long> {
	
	@Query(
			value = ""
					+ "SELECT"
					+ "	userId,"
					+ "	name"
					+ "FROM USER"
					+ "WHERE userId = ?", 
			nativeQuery = true)
	TableUser selectUserInfo(String userId);
	
	TableUser selectUserSign();
	
	UserVo findByUserId(LoginVo loginVo);
	
	UserDetails loadUserByUsername(String name);
	
}
