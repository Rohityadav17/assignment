package com.example.ecom.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.ecom.entity.Product;

public class RowMapperImpl implements RowMapper<Product> {

	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		Product p=new Product();
		p.setProductCategory(rs.getString(2));
		p.setProductCost(rs.getFloat(3));
		p.setProductDescription(rs.getString(4));
		p.setProductId(rs.getInt(1));
		p.setProductName(rs.getString(5));
		return p;
		
	}

}
