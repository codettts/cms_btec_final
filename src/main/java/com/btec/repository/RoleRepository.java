package com.btec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.btec.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

	
}
