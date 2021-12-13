package com.btec.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.btec.converter.UserConverter;
import com.btec.dto.UserDTO;
import com.btec.entity.UserEntity;
import com.btec.repository.ClassRepository;
import com.btec.repository.RoleRepository;
import com.btec.repository.UserRepository;
import com.btec.service.IUserService;


@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired UserConverter userConverter;
	
	@Override
	public UserDTO findOne(String username) {
		// TODO Auto-generated method stub
		UserEntity entities = userRepository.findOne(username);
		return userConverter.toDto(entities);

	}

	@Override
	public Map<String, String> findAllTrainer() {
		Long roleId = 2L;
		Map<String, String> result = new HashMap<>();
		List<UserEntity> entities = roleRepository.findOne(roleId).getUsers();
		for (UserEntity item: entities) {
			result.put(item.getUsername(), item.getFullName());
		}
		return result;
	}

	@Override
	public List<UserDTO> findAll(Pageable pageable) {
		List<UserDTO> model = new ArrayList<>();
		List<UserEntity> entities = userRepository.findAll(pageable).getContent();
		for (UserEntity item: entities) {
			UserDTO userDTO = userConverter.toDto(item);
			model.add(userDTO);
		}
		return model;
	}
	

	@Override
	public int getTotalItem() {
		return (int) userRepository.count();
	}
//	@Override
//	public Map<String, String> findAll() {
//		Map<String, String> result = new HashMap<>();
//		List<UserEntity> entities = userRepository.findAll();
//		for (UserEntity item: entities) {
//			result.put(item.getUsername(), item.getFullName());
//		}
//		return result;
//	}
	

	@Override
	@Transactional
	public UserDTO save(UserDTO dto) {
		// TODO Auto-generated method stub
		UserEntity userEntity = new UserEntity();
		if(dto.getUsername() != null) {
			UserEntity oldUser = userRepository.findOne(dto.getUsername());
			userEntity = userConverter.toEntity(oldUser,dto);
		}else {
			userEntity = userConverter.toEntity(dto);
		}
		return userConverter.toDto(userRepository.save(userEntity));
	}

//	@Override
//	@Transactional
//	public void delete(String usernames) {
//		for (String username: usernames) {
//			userRepository.delete(username);
//		}
//	}

}
