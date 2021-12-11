package com.btec.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.btec.converter.MajorConverter;
import com.btec.dto.AsmDTO;
import com.btec.dto.MajorDTO;
import com.btec.entity.AsmEntity;
import com.btec.entity.MajorEntity;
import com.btec.entity.UserEntity;
import com.btec.repository.MajorRepository;
import com.btec.service.IMajorService;


@Service
public class MajorService implements IMajorService {

	@Autowired
	private MajorRepository majorRepository;
	
	@Autowired
	private MajorConverter majorConverter;
	
	@Override
	public Map<Long, String> findAll() {
		Map<Long, String> result = new HashMap<>();
		List<MajorEntity> entities = majorRepository.findAll();
		for (MajorEntity item: entities) {
			result.put(item.getMajorId(), item.getMajorName());
		}
		return result;
	}

	@Override
	public List<MajorDTO> findAll(Pageable pageable) {
		List<MajorDTO> models = new ArrayList<>();
		List<MajorEntity> entities = majorRepository.findAll(pageable).getContent();
		for (MajorEntity item: entities) {
			MajorDTO majorDTO = majorConverter.toDto(item);
			models.add(majorDTO);
		}
		return models;
	}

	@Override
	public MajorDTO findById(long majorId) {
		MajorEntity entity = majorRepository.findOne(majorId);
		return majorConverter.toDto(entity);
	}

	@Override
	@Transactional
	public MajorDTO save(MajorDTO dto) {
		MajorEntity majorEntity = new MajorEntity();
		if(dto.getMajorId() != null) {
			MajorEntity oldNew = majorRepository.findOne(dto.getMajorId());
			majorEntity = majorConverter.toEntity(oldNew,dto);
		}else {
			majorEntity = majorConverter.toEntity(dto);
		}
		return majorConverter.toDto(majorRepository.save(majorEntity));
	}

	@Override
	@Transactional
	public void delete(long[] majorIds) {
		for (long majorId: majorIds) {
			majorRepository.delete(majorId);
		}
		
	}

	@Override
	public int getTotalItem() {
		return (int) majorRepository.count();
	}

}
