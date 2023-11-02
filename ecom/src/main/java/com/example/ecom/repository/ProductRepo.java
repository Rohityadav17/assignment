package com.example.ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ecom.entity.Product;
import com.example.ecom.entity.User;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer>{

	Product save(Product products);


}
