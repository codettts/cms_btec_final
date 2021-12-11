package com.btec.converter;

import org.springframework.stereotype.Component;

import com.btec.dto.UserDTO;
import com.btec.entity.UserEntity;

@Component
public class UserConverter {

	public UserDTO toDto(UserEntity entity) {
		UserDTO result = new UserDTO();
		result.setUsername(entity.getUsername());
		result.setPassword(entity.getPassword());
		result.setFullName(entity.getFullName());
		result.setDob(entity.getDob());
		result.setEmail(entity.getEmail());
		result.setPhoneNumber(entity.getPhoneNumber());
		return result;
	}

	public UserEntity toEntity(UserDTO dto) {
		UserEntity result = new UserEntity();
		result.setPassword(dto.getPassword());
		result.setFullName(dto.getFullName());
		result.setDob(dto.getDob());
		result.setEmail(dto.getEmail());
		result.setPhoneNumber(dto.getPhoneNumber());
		return result;
	}
	
	public UserEntity toEntity(UserEntity result, UserDTO dto) {
		result.setPassword(dto.getPassword());
		result.setFullName(dto.getFullName());
		result.setDob(dto.getDob());
		result.setEmail(dto.getEmail());
		result.setPhoneNumber(dto.getPhoneNumber());
		return result;
		
	}
}
