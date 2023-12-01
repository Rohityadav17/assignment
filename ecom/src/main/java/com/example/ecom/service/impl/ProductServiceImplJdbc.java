package com.example.ecom.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.ecom.dao.ProductDao;
import com.example.ecom.entity.Product;
import com.example.ecom.exception.ProductNotFoundException;
import com.example.ecom.service.ProductServiceJdbc;

@Service
public class ProductServiceImplJdbc implements ProductServiceJdbc {
	
	@Autowired
	private ProductDao productDao;

	@Override
	public int saveProduct(Product p) {
		int result = productDao.saveProductByJdbcTamplate(p);
		return result;
	}

	@Override
	public Product updateProductById(Product newDetails) throws ProductNotFoundException {
            int result = productDao.updateProductByJdbcTemplate(newDetails);
            if (result > 0) {
                return newDetails;
            } else {
                throw new ProductNotFoundException("Product with ID " + newDetails.getProductId() + " not found.");
            }
	}

	@Override
	public String deleteProductById(int id) {
		int result = productDao.deleteProductByJdbcTemplate(id);
		if (result == 1)
			return "Product with id " + id + " deleted successsfully!!!";
		else
			return "Product not exist !!";
	}

	@Override
	public Product getProduct(int productsId) throws ProductNotFoundException {
		return productDao.getProduct(productsId);

	}

	@Override
	public List<Product> getProducts() {
		return productDao.getProducts();
	}

}
