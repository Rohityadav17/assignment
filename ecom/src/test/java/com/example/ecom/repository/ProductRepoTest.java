package com.example.ecom.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.ecom.entity.Product;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ProductRepoTest {


    @Autowired
    private ProductRepo productRepo;

    @Test
    public void testSaveProduct() {
        // Create a sample product
        Product product = new Product();
        product.setProductId(1);
        product.setProductCategory("Shoes");
        product.setProductCost(1000);
        product.setProductDescription("Sports");
        product.setProductName("Adidas");

        // Persist the product using the TestEntityManager
        Product savedProduct = productRepo.save(product);

        // Retrieve the product from the repository
        Optional<Product> retrievedProduct = productRepo.findById(savedProduct.getProductId());

        // Perform assertions
        assertNotNull(savedProduct);
        assertNotNull(retrievedProduct);
        assertEquals(1, savedProduct.getProductId());
        assertEquals("Adidas", savedProduct.getProductName());
        assertEquals(1000, savedProduct.getProductCost());
        assertEquals("Sports", savedProduct.getProductDescription());
        assertEquals("Shoes", savedProduct.getProductCategory());

        // Additional assertions for the retrieved product
        assertEquals(savedProduct, retrievedProduct.get());
    }
}

