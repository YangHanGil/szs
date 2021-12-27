package com.job.springBoot.dataSource.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

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
	
	@Query()
	TableUser selectUserSign();
	
}
