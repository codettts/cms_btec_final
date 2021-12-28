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
<<<<<<< HEAD
		result.setModifiedBy(entity.getModifiedBy());
		result.setModifiedDate(entity.getModifiedDate());
		result.setCreatedBy(entity.getCreatedBy());
		result.setCreatedDate(entity.getCreatedDate());
=======
		result.setAvatar(entity.getAvatar());
		result.setGender(entity.getGender());
		result.setCountry(entity.getCountry());
>>>>>>> d33873fcb3a395b3f537cd04261aedef2cd8d536
		result.setDob(entity.getDob());
		result.setEmail(entity.getEmail());
		result.setPhoneNumber(entity.getPhoneNumber());
		return result;
	}

	public UserEntity toEntity(UserDTO dto) {
		UserEntity result = new UserEntity();
		result.setUsername(dto.getUsername());
		result.setPassword(dto.getPassword());
		result.setFullName(dto.getFullName());
<<<<<<< HEAD
		result.setModifiedBy(dto.getModifiedBy());
		result.setModifiedDate(dto.getModifiedDate());
		result.setCreatedBy(dto.getCreatedBy());
		result.setCreatedDate(dto.getCreatedDate());
=======
		result.setAvatar(dto.getAvatar());
		result.setCountry(dto.getCountry());
		result.setGender(dto.getGender());
>>>>>>> d33873fcb3a395b3f537cd04261aedef2cd8d536
		result.setDob(dto.getDob());
		result.setEmail(dto.getEmail());
		result.setPhoneNumber(dto.getPhoneNumber());
		return result;
	}
	
	public UserEntity toEntity(UserEntity result, UserDTO dto) {
		result.setFullName(dto.getFullName());
<<<<<<< HEAD
		result.setModifiedBy(dto.getModifiedBy());
		result.setModifiedDate(dto.getModifiedDate());
		result.setCreatedBy(dto.getCreatedBy());
		result.setCreatedDate(dto.getCreatedDate());
=======
		result.setAvatar(dto.getAvatar());
		result.setCountry(dto.getCountry());
		result.setGender(dto.getGender());
>>>>>>> d33873fcb3a395b3f537cd04261aedef2cd8d536
		result.setDob(dto.getDob());
		result.setEmail(dto.getEmail());
		result.setPhoneNumber(dto.getPhoneNumber());
		return result;
		
	}
}
