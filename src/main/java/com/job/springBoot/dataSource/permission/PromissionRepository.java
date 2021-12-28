package com.job.springBoot.dataSource.permission;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PromissionRepository extends JpaRepository<TablePermission, Long> {

	List<TablePermission> findByName(String name);;
}
