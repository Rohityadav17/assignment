package com.example.ecom.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.ecom.entity.Product;
import com.example.ecom.exception.ProductNotFoundException;
import com.example.ecom.repository.ProductRepo;

public class ProductServiceImplTest {

    @InjectMocks
    private ProductServiceImpl productService;

    @Mock
    private ProductRepo productRepo;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddProducts() {
        Product product = new Product();
        when(productRepo.save(product)).thenReturn(product);

        Product savedProduct = productService.addProducts(product);

        assertNotNull(savedProduct);
        assertEquals(product, savedProduct);
    }

    @Test
    public void testViewProductsFound() throws ProductNotFoundException {
        Product product = new Product();
        product.setProductId(1);
        when(productRepo.existsById(1)).thenReturn(true);
        when(productRepo.findById(1)).thenReturn(Optional.of(product));

        Product foundProduct = productService.viewProducts(product);

        assertNotNull(foundProduct);
        assertEquals(1, foundProduct.getProductId());
    }

    @Test
    public void testViewProductsNotFound() {
        Product product = new Product();
        product.setProductId(1);
        when(productRepo.existsById(1)).thenReturn(false);

        assertThrows(ProductNotFoundException.class, () -> productService.viewProducts(product));
    }

    @Test
    public void testUpdateProducts() throws ProductNotFoundException {
        Product product = new Product();
        when(productRepo.existsById(product.getProductId())).thenReturn(true);
        when(productRepo.save(product)).thenReturn(product);

        Product updatedProduct = productService.updateProducts(product);

        assertNotNull(updatedProduct);
    }

    @Test
    public void testUpdateProductsNotFound() {
        Product product = new Product();
        when(productRepo.existsById(product.getProductId())).thenReturn(false);

        assertThrows(ProductNotFoundException.class, () -> productService.updateProducts(product));
    }

    @Test
    public void testDeleteProducts() throws ProductNotFoundException {
        int productId = 1;
        when(productRepo.existsById(productId)).thenReturn(true);

        Product deletedProduct = productService.deleteProducts(productId);

        assertNull(deletedProduct);
        verify(productRepo, times(1)).deleteById(productId);
    }

    @Test
    public void testDeleteProductsNotFound() {
        int productId = 1;
        when(productRepo.existsById(productId)).thenReturn(false);

        assertThrows(ProductNotFoundException.class, () -> productService.deleteProducts(productId));
    }

    @Test
    public void testShowAllProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product());
        products.add(new Product());
        when(productRepo.findAll()).thenReturn(products);

        List<Product> productList = productService.showAllProducts();

        assertNotNull(productList);
        assertEquals(2, productList.size());
    }
}
