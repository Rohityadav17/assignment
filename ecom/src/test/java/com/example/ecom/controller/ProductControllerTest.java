package com.example.ecom.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.ecom.entity.Product;
import com.example.ecom.exception.ProductNotFoundException;
import com.example.ecom.service.impl.ProductServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class ProductControllerTest {

	@InjectMocks
	private ProductController productController;

	@Mock
	private ProductServiceImpl productService;
	/*
	 * @Before public void setUp() { MockitoAnnotations.initMocks(this); }
	 * 
	 */

	@Test
	public void testAddProductValid() {
		Product product = new Product();
		product.setProductId(1);
		product.setProductCategory("Shoes");
		product.setProductCost(1000);
		product.setProductDescription("Sports");
		product.setProductName("Adidas");
		when(productService.addProducts(product)).thenReturn(product);

		Product response = productController.addProduct(product);

		assertNotNull(response);
	}

	@Test
	public void testUpdateProducts() throws ProductNotFoundException {
		Product product = new Product();
		when(productService.updateProducts(product)).thenReturn(product);

		Product response = productController.updateProducts(product);

		assertNotNull(response);
	}

	@Test
	public void testRemoveProducts() throws ProductNotFoundException {
		int productId = 1;
		Product product = new Product();
		when(productService.deleteProducts(productId)).thenReturn(product);

		Product response = productController.removeProducts(productId);

		assertNotNull(response);
	}

	@Test
	public void testGetProducts() throws ProductNotFoundException {
		Product product = new Product();
		product.setProductId(1);
		product.setProductCategory("Shoes");
		product.setProductCost(1000);
		product.setProductDescription("Sports");
		product.setProductName("Adidas");
		when(productService.viewProducts(any())).thenReturn(product);

		Product response = productController.getProducts(1);

		assertNotNull(response);
		assertEquals(Integer.valueOf(1), response.getProductId());
		assertEquals("Adidas", response.getProductName());
		assertEquals(1000, response.getProductCost(), 0.001);
		assertEquals("Sports", response.getProductDescription());
		assertEquals("Shoes", response.getProductCategory());
	}

}
