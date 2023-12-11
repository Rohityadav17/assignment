package com.example.ecom.service.impl;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.ecom.dao.ProductDao;
import com.example.ecom.entity.Product;
import com.example.ecom.exception.ProductNotFoundException;
import com.example.ecom.service.impl.ProductServiceImplJdbc;

public class ProductServiceImplJdbcTest {

    @Mock
    private ProductDao productDao;

    @InjectMocks
    private ProductServiceImplJdbc productServiceJdbc;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveProduct() {
        Product product = new Product();
        when(productDao.saveProductByJdbcTamplate(product)).thenReturn(1);

        int result = productServiceJdbc.saveProduct(product);

        assertEquals(1, result);
    }

    @Test
    public void testUpdateProductById() throws ProductNotFoundException {
        Product updatedProduct = new Product();
        updatedProduct.setProductId(1);
        when(productDao.updateProductByJdbcTemplate(updatedProduct)).thenReturn(1);

        Product result = productServiceJdbc.updateProductById(updatedProduct);

        assertEquals(updatedProduct, result);
    }

    @Test(expected = ProductNotFoundException.class)
    public void testUpdateProductById_ProductNotFoundException() throws ProductNotFoundException {
        Product updatedProduct = new Product();
        updatedProduct.setProductId(1);
        when(productDao.updateProductByJdbcTemplate(updatedProduct)).thenReturn(0);

        productServiceJdbc.updateProductById(updatedProduct);
    }

    @Test
    public void testDeleteProductById_Success() {
        int productId = 1;
        when(productDao.deleteProductByJdbcTemplate(productId)).thenReturn(1);

        String result = productServiceJdbc.deleteProductById(productId);

        assertEquals("Product with id 1 deleted successsfully!!!", result);
    }

    @Test
    public void testDeleteProductById_ProductNotExists() {
        int productId = 1;
        when(productDao.deleteProductByJdbcTemplate(productId)).thenReturn(0);

        String result = productServiceJdbc.deleteProductById(productId);

        assertEquals("Product not exist !!", result);
    }

    @Test
    public void testGetProduct() throws ProductNotFoundException {
        int productId = 1;
        Product expectedProduct = new Product();
        when(productDao.getProduct(productId)).thenReturn(expectedProduct);

        Product result = productServiceJdbc.getProduct(productId);

        assertEquals(expectedProduct, result);
    }

    @Test
    public void testGetProducts() {
        List<Product> expectedProducts = Arrays.asList(new Product(), new Product());
        when(productDao.getProducts()).thenReturn(expectedProducts);

        List<Product> result = productServiceJdbc.getProducts();

        assertEquals(expectedProducts, result);
    }
}
