package com.example.ecom.dao;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.ecom.entity.Product;
import com.example.ecom.exception.ProductNotFoundException;

@RunWith(MockitoJUnitRunner.class)
public class ProductDaoImplTest {

	@Mock
	private JdbcTemplate jdbcTemplate;

	@InjectMocks
	private ProductDaoImpl productDao;
	/*
	 * @Before public void setup() { MockitoAnnotations.initMocks(this); }
	 * 
	 */

	@Test
	public void testSaveProductByJdbcTemplate() {
		Product product = new Product();
		product.setProductId(1);
		product.setProductName("TestProduct");
		product.setProductCost(100);
		product.setProductCategory("TestCategory");
		product.setProductDescription("TestDescription");
		when(jdbcTemplate.update(anyString(), anyInt(), anyString(), anyFloat(), anyString(), anyString()))
				.thenReturn(Integer.valueOf(1));
		int result = productDao.saveProductByJdbcTamplate(product);
		assertEquals(1, result);

	}

	@Test
	public void testGetProduct() throws ProductNotFoundException {
		int productId = 1;
		Product product = new Product();
		product.setProductId(productId);
		product.setProductName("TestProduct");
		product.setProductCost(100);
		product.setProductCategory("TestCategory");
		product.setProductDescription("TestDescription");

		when(jdbcTemplate.queryForObject(anyString(), any(RowMapperImpl.class), eq(productId))).thenReturn(product);

		Product result = productDao.getProduct(productId);

		assertEquals(product, result);

	}

	@Test
	public void testGetProducts() {
		Product product1 = new Product();
		product1.setProductId(1);
		product1.setProductName("TestProduct1");
		product1.setProductCost(100);
		product1.setProductCategory("TestCategory1");
		product1.setProductDescription("TestDescription1");

		Product product2 = new Product();
		product2.setProductId(2);
		product2.setProductName("TestProduct2");
		product2.setProductCost(200);
		product2.setProductCategory("TestCategory2");
		product2.setProductDescription("TestDescription2");

		List<Product> productList = Arrays.asList(product1, product2);

		when(jdbcTemplate.query(anyString(), any(RowMapperImpl.class))).thenReturn(productList);

		List<Product> result = productDao.getProducts();

		assertEquals(productList, result);

	}

	@Test
	public void testUpdateProductByJdbcTemplate() {
		Product product = new Product();
		product.setProductId(1);
		product.setProductName("UpdatedProductName");
		product.setProductCost(500);
		product.setProductCategory("UpdatedCategory");
		product.setProductDescription("UpdatedDescription");

		when(jdbcTemplate.update(anyString(), anyInt(), anyString(), anyFloat(), anyString(), anyString(), anyInt()))
				.thenReturn(1);

		int result = productDao.updateProductByJdbcTemplate(product);

		assertEquals(1, result);
	}

	@Test
	public void testDeleteProductByJdbcTemplate() {
		int productId = 1;

		when(jdbcTemplate.update(anyString(), anyInt())).thenReturn(1);

		int result = productDao.deleteProductByJdbcTemplate(productId);

		assertEquals(1, result);
		
	}
}
