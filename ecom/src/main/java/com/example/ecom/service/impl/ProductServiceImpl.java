package com.example.ecom.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecom.exception.ProductNotFoundException;
import com.example.ecom.dao.ProductDao;
import com.example.ecom.entity.Product;
import com.example.ecom.repository.ProductRepo;
import com.example.ecom.service.ProductService;

import java.util.List;

// business logic for products service
@Service
public class ProductServiceImpl implements ProductService {

	private ProductRepo productsRepository;
	private ProductDao productDao;

	@Autowired
	public ProductServiceImpl(ProductRepo productsRepository, ProductDao productDao) {
		this.productsRepository = productsRepository;
		this.productDao = productDao;
	}

	public ProductServiceImpl(ProductRepo productsRepository) {
		this.productsRepository = productsRepository;
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
	public List<Product> showAllProducts() {
		return productsRepository.findAll();
	}

	// -------JDBC Template----
	@Override
	public int saveProduct(Product p) {
		int result = productDao.saveProductByJdbcTamplate(p);
		return result;
	}

	@Override
	public Product updateProductById(Product newDetails) {
		int result = productDao.updateProductByJdbcTemplate(newDetails);
		return null;
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

	public List<Product> getProducts() {
		return productDao.getProducts();
	}

	// JDBC TEmplate end
}
