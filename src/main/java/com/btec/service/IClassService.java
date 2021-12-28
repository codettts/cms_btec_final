package com.btec.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;

import com.btec.dto.AsmDTO;
import com.btec.dto.ClassDTO;
<<<<<<< HEAD
import com.btec.entity.AsmEntity;
import com.btec.entity.ClassEntity;
=======
import com.btec.dto.UserDTO;
>>>>>>> d33873fcb3a395b3f537cd04261aedef2cd8d536

public interface IClassService {
	List<ClassDTO> findAll(Pageable pageable);
	List<AsmDTO> findByClassId(Long classId);
	int getTotalItem();
	Map<Long, String> findAll();
	ClassDTO findOne(Long classId);
	ClassDTO save(ClassDTO dto);
<<<<<<< HEAD
	void delete(long[] classIds);

=======
	void delete(long[] classId);
	List<UserDTO> listTraineeOfClass(Long classId, String username);
	void removeUser(String username, Long classId);
>>>>>>> d33873fcb3a395b3f537cd04261aedef2cd8d536
}
