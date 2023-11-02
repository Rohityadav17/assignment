package com.example.ecom.service;

import java.util.List;

import com.example.ecom.exception.ProductNotFoundException;
import com.example.ecom.entity.Product;
import com.example.ecom.entity.User;

// custom service declarations
public interface ProductService {

    public Product addProducts(Product Products);

    public Product viewProducts(Product Products) throws ProductNotFoundException;

    public Product updateProducts(Product Products) throws ProductNotFoundException;

    public Product deleteProducts(int id) throws ProductNotFoundException;

    public List<Product> showAllProducts();

	int saveProduct(Product p);

	Product updateProductById(Product newDetails);

	String deleteProductById(int id);


	Product getProduct(int product_Id) throws ProductNotFoundException;

}
