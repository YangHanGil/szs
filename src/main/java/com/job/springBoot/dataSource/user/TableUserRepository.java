package com.job.springBoot.dataSource.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableUserRepository extends JpaRepository<TableUser, Long> {

	
}
