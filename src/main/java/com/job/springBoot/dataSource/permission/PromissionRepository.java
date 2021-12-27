package com.job.springBoot.dataSource.permission;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

public interface PromissionRepository extends JpaRepository<TablePermission, Long> {

}
