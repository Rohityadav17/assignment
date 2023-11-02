package com.example.ecom.service;

import java.util.List;


import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.example.ecom.dto.LoginDTO;
import com.example.ecom.dto.UserDTO;
import com.example.ecom.entity.User;
import com.example.ecom.exception.UserNotFoundException;
import com.example.ecom.response.LoginResponse;

@Service
public interface UserService {

	String addUser(@Validated UserDTO userDTO);

	LoginResponse loginUser(LoginDTO loginDTO);

	UserDTO viewUser(User u) throws UserNotFoundException;

	User updateUser(User user) throws UserNotFoundException;

	User deleteUser(@Validated int id) throws UserNotFoundException;

	List<UserDTO> showAllUser();


}
