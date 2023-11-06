package com.example.ecom.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecom.entity.Product;
import com.example.ecom.exception.ProductNotFoundException;
import com.example.ecom.service.impl.ProductServiceImpl;

@RestController
@RequestMapping("/products")
@CrossOrigin
public class ProductController {

	@Autowired
	private ProductServiceImpl productsService;

	// create
	@PostMapping("/add")
	public Product addProduct(@Validated @RequestBody Product products) {
		if (products == null || products.getProductName() == null || products.getProductCost() <= 0) {
			throw new IllegalArgumentException("Product data is invalid");
		}

		return productsService.addProducts(products);
	}

	// update
	@PutMapping("/update")
	public Product updateProducts(@Validated @RequestBody Product products) throws ProductNotFoundException {
		return productsService.updateProducts(products);
	}

	// delete
	@DeleteMapping("/remove/{productsId}")
	public Product removeProducts(@PathVariable int productsId) throws ProductNotFoundException {
		return productsService.deleteProducts(productsId);
	}

	// read
	@GetMapping("/view/{productsId}")
	public Product getProducts(@PathVariable int productsId) throws ProductNotFoundException {
		Product products = new Product();
		products.setProductId(productsId);
		return productsService.viewProducts(products);
	}

	// read
	@GetMapping("/show")
	public List<Product> getAllProducts(@RequestParam(value = "pageNumber") Integer pageNumber,
	        @RequestParam(value = "pageSize") Integer pageSize,
	        @RequestParam(value = "sortField", required = false, defaultValue = "productId") String sortField,
	        @RequestParam(value = "sortOrder", required = false, defaultValue = "ascending") String sortOrder) {
	    System.out.println("PageNumber: " + pageNumber + " PageSize:" + pageSize);
	    if (pageNumber == null || pageSize == null) {
	        return Collections.emptyList();
	    }
	    return productsService.showAllProducts(pageNumber, pageSize, sortField,sortOrder);
	}


}