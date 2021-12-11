package com.btec.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;

import com.btec.dto.MajorDTO;

public interface IMajorService {
	Map<Long, String> findAll();
	List<MajorDTO> findAll(Pageable pageable);
	MajorDTO findById(long majorId);
	MajorDTO save(MajorDTO dto);
	void delete(long[] majorIds);
	int getTotalItem();
}
