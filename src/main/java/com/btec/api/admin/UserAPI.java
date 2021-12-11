package com.btec.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.btec.dto.UserDTO;
import com.btec.service.IUserService;

@RestController(value = "accOfAdmin")
public class UserAPI {

	
	@Autowired
	private IUserService userService;
	
	@PostMapping("/api/user")
	public UserDTO addUser(@RequestBody UserDTO addUserDTO) {
		return userService.save(addUserDTO);
	}
	
	@PutMapping("/api/user")
	public UserDTO updateUser(@RequestBody UserDTO updateUserDTO) {
		return userService.save(updateUserDTO);
	}
	
//	@DeleteMapping("/api/user")
//	public void deleteUser(@RequestBody String username) {
//		userService.delete(username);
//	}
	

}
