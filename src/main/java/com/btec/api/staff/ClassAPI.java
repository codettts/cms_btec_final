package com.btec.api.staff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.btec.dto.ClassDTO;
import com.btec.service.IClassService;

@RestController(value = "classAPIOfStaff")
public class ClassAPI {
	
	@Autowired
	private IClassService classService;
	
	@PostMapping("/api/class")
	public ClassDTO addNewClass(@RequestBody ClassDTO newclassDTO) {
		return classService.save(newclassDTO);
	}
	
	@PutMapping("/api/class")
	public ClassDTO editClass(@RequestBody ClassDTO editclassDTO) {
		return classService.save(editclassDTO);
	}
<<<<<<< HEAD
	@DeleteMapping("/api/class")
	public void deleteClass(@RequestBody long[] classIds) {
		classService.delete(classIds);
=======
	
	@DeleteMapping("/api/class")
	public void deleteAsm(@RequestBody long[] classId) {
		classService.delete(classId);
>>>>>>> d33873fcb3a395b3f537cd04261aedef2cd8d536
	}
}
