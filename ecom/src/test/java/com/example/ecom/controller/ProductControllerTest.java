package com.example.ecom.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.example.ecom.entity.Product;
import com.example.ecom.exception.ProductNotFoundException;
import com.example.ecom.service.impl.ProductServiceImpl;

public class ProductControllerTest {

    @InjectMocks
    private ProductController productController;

    @Mock
    private ProductServiceImpl productService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

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
    public void testAddProductInvalid() {
        Product product = new Product();
        product.setProductCost(-1);

        assertThrows(IllegalArgumentException.class, () -> productController.addProduct(product));
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
        assertEquals(1, response.getProductId());
        assertEquals("Adidas", response.getProductName());
        assertEquals(1000, response.getProductCost());
        assertEquals("Sports",response.getProductDescription());
        assertEquals("Shoes",response.getProductCategory());
      
    }


    @Test
    public void testGetAllProducts() {
        when(productService.showAllProducts()).thenReturn(new ArrayList<>());

        List<Product> response = productController.getAllProducts();

        assertNotNull(response);
    }
}

