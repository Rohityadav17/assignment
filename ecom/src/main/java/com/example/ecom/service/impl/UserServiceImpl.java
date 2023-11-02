package com.example.ecom.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.example.ecom.controller.UserController;
import com.example.ecom.dto.LoginDTO;
import com.example.ecom.dto.UserDTO;
import com.example.ecom.entity.User;
import com.example.ecom.exception.UserNotFoundException;
import com.example.ecom.repository.UserRepo;
import com.example.ecom.response.LoginResponse;
import com.example.ecom.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private UserDTO userdto;

	@Override
	public String addUser(UserDTO userDTO) {
		User user = new User(userDTO.getUserId(), userDTO.getUserName(), userDTO.getEmail(),
               userDTO.getPassword(), userDTO.getRoles());

        try {
            userRepo.save(user);
            logger.info("User added: {}", user.getUserName());
            return user.getUserName();
        } catch (Exception e) {
            logger.error("Error adding user: " + e.getMessage(), e);
            throw e; 
        }
	}

	@Override
	public LoginResponse loginUser(LoginDTO loginDTO) {
		String msg = " ";
		User user1 = userRepo.findByEmail(loginDTO.getEmail());
		if (user1 != null) {
			String password = loginDTO.getPassword();
			String encodedPassword = user1.getPassword();
			Boolean isPwdRight = password.equals(encodedPassword);
			if (isPwdRight) {
				// Optional<User>
				// user=userRepo.findOneByEmailAndPassword(loginDTO.getEmail(),loginDTO.getPassword());
				// if(user.isPresent()) {s
				return new LoginResponse("Login Success", true);
				// }else {
				// return new LoginResponse("Login Failed",false);
				// }
			} else {
				return new LoginResponse("Wrong Password Entered", false);
			}

		} else {
			return new LoginResponse("Email Doesnot Exist", false);
		}
	}

	@Override
	public UserDTO viewUser(User user) throws UserNotFoundException {
		try {
	        if (userRepo.existsById(user.getUserId())) {
	            User u = userRepo.findById(user.getUserId()).get();
	            userdto.setUserId(u.getUserId());
	            userdto.setUserName(u.getUserName());
	            userdto.setEmail(u.getEmail());
	            return userdto;
	        } else {
	            throw new UserNotFoundException("User Not Found");
	        }
	    } catch (Exception e) {
	        logger.error("Error viewing user: " + e.getMessage(), e);
	        throw e; 
	    }
	}

	@Override
	public User updateUser(User user) throws UserNotFoundException {
		try {
            if (userRepo.existsById(user.getUserId())) {
                User updatedUser = userRepo.save(user);

                logger.info("User updated: {}", updatedUser.getUserName());
                return updatedUser;
            } else {
                throw new UserNotFoundException("User Not Found");
            }
        } catch (Exception e) {
            logger.error("Error updating user: " + e.getMessage(), e);
            throw e; // Re-throw the exception to be handled by the controller
        }
	}

	@Override
	public User deleteUser(@Validated int id) throws UserNotFoundException {
		  try {
		        if (userRepo.existsById(id)) {
		            userRepo.deleteById(id);
		            return null;
		        } else {
		            throw new UserNotFoundException("User Not Found");
		        }
		    } catch (Exception e) {
		        logger.error("Error deleting user with ID " + id + ": " + e.getMessage(), e);
		        throw e; // Re-throw the exception to be handled by the controller
		    }
	}

	@Override
	public List<UserDTO> showAllUser() {
		List<User> users = userRepo.findAll();
		List<UserDTO> userdtos = new ArrayList<>();

		for (User user : users) {
			UserDTO userdto = new UserDTO();
			userdto.setUserId(user.getUserId());
			userdto.setUserName(user.getUserName());
			userdto.setEmail(user.getEmail());
			userdtos.add(userdto);
		}

		return userdtos;
	}
}
