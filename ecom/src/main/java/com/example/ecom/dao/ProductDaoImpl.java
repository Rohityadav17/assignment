package com.example.ecom.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.ecom.entity.Product;
import com.example.ecom.exception.ProductNotFoundException;

public class ProductDaoImpl implements ProductDao {
	private JdbcTemplate jdbcTemplate;


	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int saveProductByJdbcTamplate(Product p) {
		System.out.println("Inside Dao layer...");

//		String query = "insert into product(product_name, cost, color, storage, ram, operator, rating) "
//				+ "values('"+p.getProductName()+"', '"+p.getCost()+"', '"+p.getColor()+"', "
//						+ "'"+p.getStorage()+"', '"+p.getRam()+"', '"+p.getOperator()+"', '"+p.getRating()+"')";
//		
//		int result = this.jdbcTemplate.update(query);

		String query = "insert into products(product_id,product_name, product_cost,category,description) values(?,?,?,?,?)";
		int result = this.jdbcTemplate.update(query, p.getProductId(), p.getProductName(), p.getProductCost(),
				p.getProductCategory(), p.getProductDescription());
		System.out.println("Product Added..");
		return result;

	}

	@Override
	public int updateProductByJdbcTemplate(Product p) {
		System.out.println("Inside Dao layer for update...");

		String query = "update products set product_id=?, product_name=?, product_cost=?, category=?, description=? where product_id = ?";

		int result = this.jdbcTemplate.update(query, p.getProductId(), p.getProductName(), p.getProductCost(),
				p.getProductCategory(), p.getProductDescription(), p.getProductId());
		System.out.println("Product Updated ...");
		return result;
	}

	@Override
	public int deleteProductByJdbcTemplate(int product_id) {
		System.out.println("Inside Dao layer for Delete...");
		String query = "delete from products where product_id=?";
		int result = this.jdbcTemplate.update(query, product_id);
		return result;
	}

	@Override
	public Product getProduct(int product_id) throws ProductNotFoundException {
		System.out.println("Inside ProductDao");
		String query = "SELECT * FROM products WHERE product_id = ?";
		try {
			RowMapper<Product> rowMapper = new RowMapperImpl();
			Product p = this.jdbcTemplate.queryForObject(query, rowMapper, product_id);
			System.out.println("Value of p: " + p);
			if (p == null) {
				throw new ProductNotFoundException("Product not found with ID: " + product_id);
			}
			return p;
		} catch (DataAccessException dae) {
			dae.printStackTrace();
			throw new ProductNotFoundException("Error fetching product: " + dae.getMessage());
		}
	}

	@Override
	public List<Product> getProducts() {
		String query = "select * from products";
		List<Product> products = this.jdbcTemplate.query(query, new RowMapperImpl());
		return products;
	}

}
