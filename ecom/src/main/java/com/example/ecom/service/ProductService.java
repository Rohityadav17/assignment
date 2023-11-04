package com.example.ecom.service;

import java.util.List;

import com.example.ecom.exception.ProductNotFoundException;
import com.example.ecom.entity.Product;
import com.example.ecom.entity.User;

public interface ProductService {

	Product addProducts(Product products);

	Product viewProducts(Product Products) throws ProductNotFoundException;

	Product updateProducts(Product products) throws ProductNotFoundException;

	Product deleteProducts(int productId) throws ProductNotFoundException;

	List<Product> showAllProducts(Integer pageNumber, Integer pageSize);

   

}
