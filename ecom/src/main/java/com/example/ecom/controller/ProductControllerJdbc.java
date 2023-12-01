package com.example.ecom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecom.entity.Product;
import com.example.ecom.exception.ProductNotFoundException;
import com.example.ecom.service.impl.ProductServiceImplJdbc;

@RestController
@RequestMapping("/products/jdbc")
@CrossOrigin
public class ProductControllerJdbc {

	@Autowired
	private ProductServiceImplJdbc psJdbc;

	@PostMapping("/add")
	public int saveProduct(@Validated @RequestBody Product products) {
		if (products == null || products.getProductName() == null || products.getProductCost() <= 0) {
			throw new IllegalArgumentException("Product data is invalid");
		}
		return psJdbc.saveProduct(products);
	}

	/* @PutMapping("/update")
	public Product updateProductById(@Validated @RequestBody Product products) throws ProductNotFoundException {
		return psJdbc.updateProductById(products);
	}  */
	
	@PutMapping("/update")
    public ResponseEntity<?> updateProductById(@Validated @RequestBody Product newDetails) {
        try {
            Product updatedProduct = psJdbc.updateProductById(newDetails);
            return ResponseEntity.ok(updatedProduct);
        } catch (ProductNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

	@DeleteMapping("/delete/{productsId}")
	public String deleteProducts(@PathVariable int productsId) throws ProductNotFoundException {
		return psJdbc.deleteProductById(productsId);
	}

	@GetMapping("/getproduct/{productsId}")
	public Product getProduct(@PathVariable Integer productsId) throws ProductNotFoundException {
		return psJdbc.getProduct(productsId);
	}

	@GetMapping("/showproducts")
	public List<Product> getProducts() {
		return psJdbc.getProducts();
	}

}
