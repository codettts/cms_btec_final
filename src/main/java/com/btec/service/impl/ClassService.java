package com.btec.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.btec.constant.SystemConstant;
import com.btec.converter.AsmConverter;
import com.btec.converter.ClassConverter;
import com.btec.converter.UserConverter;
import com.btec.dto.AsmDTO;
import com.btec.dto.ClassDTO;
import com.btec.dto.UserDTO;
import com.btec.entity.AsmEntity;
import com.btec.entity.ClassEntity;
import com.btec.entity.ContentEntity;
import com.btec.entity.RoleEntity;
import com.btec.entity.SubjectEntity;
import com.btec.entity.UserEntity;
import com.btec.repository.ClassRepository;
import com.btec.repository.ContentRepository;
import com.btec.repository.RoleRepository;
import com.btec.repository.SubjectRepository;
import com.btec.repository.UserRepository;
import com.btec.service.IClassService;

@Service

public class ClassService implements IClassService {

	@Autowired
	private AsmConverter asmConverter;

	@Autowired
	private ClassRepository classRepository;

	@Autowired
	private SubjectRepository subjectRepository;

	@Autowired
	private ContentRepository contentRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserConverter userConverter;
	
	@Autowired
	private ClassConverter classConverter;

	@Override
	public List<ClassDTO> findAll(Pageable pageable) {
		List<ClassDTO> models = new ArrayList<>();
		List<ClassEntity> entities = classRepository.findAll(pageable).getContent();
		for (ClassEntity classlist : entities) {
			ClassDTO classDTO = classConverter.toDto(classlist);
			models.add(classDTO);
		}
		return models;
	}

	@Override
	public int getTotalItem() {
		return (int) classRepository.count();
	}

	@Override
	public Map<Long, String> findAll() {
		Map<Long, String> result = new HashMap<>();
		List<ClassEntity> entities = classRepository.findAll();
		for (ClassEntity item : entities) {
			result.put(item.getClassId(), item.getClassName());
		}
		return result;
	}
	


	@Override
	public ClassDTO findOne(Long classId) {
		ClassEntity entity = classRepository.findOne(classId);
		return classConverter.toDto(entity);
	}

	@Override
	@org.springframework.transaction.annotation.Transactional
	public ClassDTO save(ClassDTO dto) {
		SubjectEntity subjectclass = subjectRepository.findOne(dto.getSubjectId());
		ContentEntity contentclass = contentRepository.findOne(dto.getContentId());
<<<<<<< HEAD
		List<UserEntity> userclass = userRepository.findAllByUsernameAndStatus(dto.getUsername(),
				SystemConstant.ACTIVE_STATUS);
=======
		UserEntity user = userRepository.findOneByUsernameAndStatus(dto.getUsername(), SystemConstant.ACTIVE_STATUS);
>>>>>>> d33873fcb3a395b3f537cd04261aedef2cd8d536
		ClassEntity classEntity = new ClassEntity();
		Set<ClassEntity> classes = user.getClassuser();
		if (dto.getClassId() != null) {
			ClassEntity oldClass = classRepository.findOne(dto.getClassId());
			oldClass.setSubject(subjectclass);
			oldClass.setContent(contentclass);
			classEntity = classConverter.toEntity(oldClass, dto);
		} else {
			classEntity = classConverter.toEntity(dto);
			classEntity.setSubject(subjectclass);
			classEntity.setContent(contentclass);
			classes.add(classEntity);
		}
		user.setClassuser(classes);
		userRepository.save(user);
		return classConverter.toDto(classRepository.save(classEntity));
	}

	@Override
	public List<AsmDTO> findByClassId(Long classId) {
		List<AsmDTO> asmmodel = new ArrayList<>();
		List<AsmEntity> entities = classRepository.findOneByclassId(classId).getAsms();
		for (AsmEntity item : entities) {
			AsmDTO asmDTO = asmConverter.toDto(item);
			asmmodel.add(asmDTO);
		}
		return asmmodel;
	}
	
	@Override
	@Transactional
	public void delete(long[] classId) {
		// TODO Auto-generated method stub
		for (long classid: classId) {
			ClassEntity classEntity = classRepository.findByClassId(classid);
			classEntity.getUserclass().forEach(user -> user.getClassuser().remove(classEntity));
			userRepository.save(classEntity.getUserclass());
			classRepository.delete(classEntity);
		}
	}
	@Override
	public List<UserDTO> listTraineeOfClass(Long classId, String username) {
		Set<UserEntity> usersEntity = classRepository.findOne(classId).getUserclass();
		List<UserDTO> usersDTO = new ArrayList<>();
		Long roleId = 2L;
		RoleEntity trainerrole = roleRepository.findOne(roleId);
		for (UserEntity users: usersEntity) {
			if (!(users.getRole() == "trainer")) {
				UserDTO userDTO = userConverter.toDto(users);
				usersDTO.add(userDTO);
			}
		}
		return usersDTO;
	}
	@Override
	public void removeUser(String username, Long classId) {
		// TODO Auto-generated method stub
		UserEntity userEntity = userRepository.findOne(username);
		Set<UserEntity> users = classRepository.findOne(classId).getUserclass();
		ClassEntity classEntity = classRepository.findOne(classId);
		Set<ClassEntity> classes = userRepository.findOne(username).getClassuser();
		classes.remove(classEntity);
		users.remove(userEntity);
	}
	
	
	

	@Override
	public void delete(long[] classIds) {
		for (long classId : classIds) {
			classRepository.delete(classId);

		}
	}

	
	

}
