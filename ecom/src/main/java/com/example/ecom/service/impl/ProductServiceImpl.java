package com.example.ecom.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.ecom.exception.ProductNotFoundException;
import com.example.ecom.dao.ProductDao;
import com.example.ecom.entity.Product;
import com.example.ecom.repository.ProductRepo;
import com.example.ecom.service.ProductService;

import java.util.Collections;
import java.util.List;

import javax.sql.DataSource;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepo productsRepository;


	public ProductServiceImpl() {

	}
	
	@Override
	public Product addProducts(Product products) {
		return productsRepository.save(products);
	}

	@Override
	public Product viewProducts(Product Products) throws ProductNotFoundException {
		if (productsRepository.existsById(Products.getProductId())) {
			System.out.println(productsRepository.findById(Products.getProductId()).get());
			return productsRepository.findById(Products.getProductId()).get();
		} else {
			throw new ProductNotFoundException("Product Not Found");
		}
	}

	@Override
	public Product updateProducts(Product products) throws ProductNotFoundException {
		if (productsRepository.existsById(products.getProductId())) {
			return productsRepository.save(products);
		} else {
			throw new ProductNotFoundException("Product Not Found");
		}
	}

	@Override
	public Product deleteProducts(int productId) throws ProductNotFoundException {
		if (productsRepository.existsById(productId)) {
			productsRepository.deleteById(productId);
			return null;
		} else {
			throw new ProductNotFoundException("Product Not Found");
		}
	}

	@Override
	public List<Product> showAllProducts(Integer pageNumber, Integer pageSize) {
		if (pageNumber == null || pageSize == null || pageNumber < 0 || pageSize <= 0) {
			if (pageNumber == null || pageSize == null) {
				// Handle the case where pageNumber or pageSize is null
				return Collections.emptyList();
			}
			return Collections.emptyList();
		}

		try {
			Pageable p = PageRequest.of(pageNumber, pageSize);
			Page<Product> pageProduct = productsRepository.findAll(p);

			if (pageProduct != null) {
				return pageProduct.getContent();
			} else {
				// Handle the case when pageProduct is null, e.g., return an empty list .
				return Collections.emptyList();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}


}
