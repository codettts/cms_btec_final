package com.btec.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.btec.dto.RoleDTO;
import com.btec.entity.ClassEntity;
import com.btec.entity.RoleEntity;
import com.btec.repository.RoleRepository;
import com.btec.service.IRoleService;


@Service
public class RoleService implements IRoleService{

	@Autowired
	private RoleRepository roleRepository;
	
//	@Autowired
//	private RoleConverter roleConverter;
	
//	@Override
//	public RoleDTO findOne(Long roleId) {
//		RoleEntity entity = roleRepository.findOne(roleId);
//		return roleConverter.toDto(entity);
//	}

	@Override
	public RoleDTO findOne(Long roleId) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
