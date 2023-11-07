package com.example.ecom.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.ecom.entity.Product;
import com.example.ecom.exception.ProductNotFoundException;
import com.example.ecom.repository.ProductRepo;
import com.example.ecom.service.ProductService;
import java.util.Collections;
import java.util.List;


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
	public List<Product> showAllProducts(Integer pageNumber, Integer pageSize, String sortField, String sortOrder) {
	    if (pageNumber == null || pageSize == null || pageNumber < 0 || pageSize <= 0) {
	        return Collections.emptyList();
	    }

	    try {
	        Sort sort;
	        switch (sortOrder.toLowerCase()) {
	            case "ascending":
	                sort = Sort.by(sortField).ascending();
	                break;
	            case "descending":
	                sort = Sort.by(sortField).descending();
	                break;
	            default:
	               sort = Sort.by(sortField).ascending();;
	        }

	        Pageable p = PageRequest.of(pageNumber, pageSize, sort);
	        Page<Product> pageProduct = productsRepository.findAll(p);

	        if (pageProduct != null) {
	            return pageProduct.getContent();
	        } else {
	            return Collections.emptyList();
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        return Collections.emptyList();
	    }
	}


}
