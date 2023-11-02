package com.example.ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ecom.entity.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role, Integer>{

}
