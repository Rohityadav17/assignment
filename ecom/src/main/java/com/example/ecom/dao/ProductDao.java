package com.example.ecom.dao;

import java.util.List;

import com.example.ecom.entity.Product;
import com.example.ecom.exception.ProductNotFoundException;

public interface ProductDao {

	int saveProductByJdbcTamplate(Product p);

	int updateProductByJdbcTemplate(Product p);

	int deleteProductByJdbcTemplate(int product_id);

	Product getProduct(int productsId) throws ProductNotFoundException;

	List<Product> getProducts();

}
