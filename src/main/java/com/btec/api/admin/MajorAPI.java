package com.btec.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.btec.dto.MajorDTO;
import com.btec.service.IMajorService;

@RequestMapping(value="majorAPIOfAdmin")
public class MajorAPI {
	@Autowired
	private IMajorService majorService;
	
	@PostMapping("/api/major")
	public MajorDTO createMajor(@RequestBody MajorDTO creatMajorDTO) {
		return majorService.save(creatMajorDTO);
	}
	
	@PutMapping("/api/major")
	public MajorDTO updateMajor(@RequestBody MajorDTO updateMajorDTO) {
		return majorService.save(updateMajorDTO);
	}
	
	@DeleteMapping("/api/major")
	public void deleteMajor(@RequestBody long[] majorIds) {
		majorService.delete(majorIds);
	}
}
