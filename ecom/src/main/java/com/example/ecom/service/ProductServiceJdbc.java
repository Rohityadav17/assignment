package com.example.ecom.service;

import java.util.List;

import com.example.ecom.entity.Product;
import com.example.ecom.exception.ProductNotFoundException;

public interface ProductServiceJdbc {

	int saveProduct(Product p);

	Product updateProductById(Product newDetails);

	String deleteProductById(int id);

	Product getProduct(int productsId) throws ProductNotFoundException;

	List<Product> getProducts();

}
