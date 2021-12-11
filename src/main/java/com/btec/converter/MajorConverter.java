package com.btec.converter;

import org.springframework.stereotype.Component;

import com.btec.dto.MajorDTO;
import com.btec.entity.MajorEntity;

@Component
public class MajorConverter {

	public MajorDTO toDto(MajorEntity entity) {
		MajorDTO result = new MajorDTO();
		result.setMajorId(entity.getMajorId());
		result.setMajorName(entity.getMajorName());
		result.setMajorDesc(entity.getMajorDesc());
		return result;
	}
	
	public MajorEntity toEntity(MajorDTO dto) {
		MajorEntity result = new MajorEntity();
		result.setMajorName(dto.getMajorName());
		result.setMajorDesc(dto.getMajorDesc());
		return result;
		
	}
	public MajorEntity toEntity(MajorEntity result, MajorDTO dto) {
		result.setMajorName(dto.getMajorName());
		result.setMajorDesc(dto.getMajorDesc());
		return result;
		
	}
}
