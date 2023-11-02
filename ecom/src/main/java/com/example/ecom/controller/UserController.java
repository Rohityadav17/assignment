package com.example.ecom.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecom.dto.LoginDTO;
import com.example.ecom.dto.UserDTO;
import com.example.ecom.entity.User;
import com.example.ecom.exception.UserNotFoundException;
import com.example.ecom.response.LoginResponse;
import com.example.ecom.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("api/v1/user")
public class UserController{
	
	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@PostMapping(path="/save")
	public String saveUser(@RequestBody UserDTO userDTO){
		   try {
	            logger.info("Saving user with data: {}", userDTO);
	            String id = userService.addUser(userDTO);
	            logger.info("User saved with ID: {}", id);
	            return id;
	        } catch (Exception e) {
	            logger.error("Error saving user: " + e.getMessage(), e);
	            return "Error saving user.";
	        }
	}
	
	@PostMapping(path="/login")
	public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO){
		logger.info("Executing loginUser Method with info log level");
		LoginResponse loginResponse= userService.loginUser(loginDTO);
		return ResponseEntity.ok(loginResponse);
	}
	
	@GetMapping("/view/{id}")
	public UserDTO getUser(@PathVariable int id) throws UserNotFoundException{
		 try {
		        logger.info("Getting user with ID: {}", id);
		        User u = new User();
		        u.setUserId(id);
		        UserDTO userDTO = userService.viewUser(u);
		        logger.info("Retrieved user: {}", userDTO);
		        return userDTO;
		    } catch (UserNotFoundException e) {
		        logger.error("User not found with ID: " + id, e);
		        throw e; 
		    } catch (Exception e) {
		        logger.error("Error getting user: " + e.getMessage(), e);
		        return null;
		    }
	}
	
	@PutMapping("/update")
		public User updateUser(@Validated @RequestBody User user) throws UserNotFoundException {
	    try {
	        logger.info("Updating user with data: {}", user);
	        User updatedUser = userService.updateUser(user);
	        logger.info("User updated: {}", updatedUser);
	        return updatedUser;
	    } catch (UserNotFoundException e) {
	        logger.error("User not found for update: " + e.getMessage(), e);
	        throw e; 
	    } catch (Exception e) {
	        logger.error("Error updating user: " + e.getMessage(), e);
	        return null;
	    }
	}
	

	
	@DeleteMapping("/remove/{id}")
	public User deleteUser(@Validated @PathVariable int id ) throws UserNotFoundException {
		try {
	        logger.info("Deleting user with ID: {}", id);
	        User deletedUser = userService.deleteUser(id);
	        logger.info("User deleted: {}", deletedUser);
	        return deletedUser;
	    } catch (UserNotFoundException e) {
	        logger.error("User not found for deletion: " + e.getMessage(), e);
	        throw e; // Re-throw the exception to be handled by Spring
	    } catch (Exception e) {
	        logger.error("Error deleting user: " + e.getMessage(), e);
	        return null; // You can handle the error as needed
	    }
	}
	
	@GetMapping("/show")
	public List<UserDTO> getAllUsers(){
		logger.info("Retrieving all users");
		return userService.showAllUser();
	}
}


