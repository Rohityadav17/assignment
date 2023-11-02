package com.example.ecom.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {

	public Product() {
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private int productId;
	
	public Product(int productId, String productName, float productCost, String productCategory,
			String productDescription) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productCost = productCost;
		this.productCategory = productCategory;
		this.productDescription = productDescription;
	}

	@Column(name = "product_name", nullable = false)
	private String productName;

	@Column(name = "product_cost", nullable = false)
	private float productCost;

	@Column(name = "category", nullable = false)
	private String productCategory;

	@Column(name = "description")
	private String productDescription;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public float getProductCost() {
		return productCost;
	}

	public void setProductCost(float productCost) {
		this.productCost = productCost;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(int productsId) {
		this.productId=productsId;
		
	}
	
	  @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        Product product = (Product) o;
	        return Objects.equals(getProductId(), product.getProductId()) &&
	               Objects.equals(getProductName(), product.getProductName()) &&
	               Objects.equals(getProductCost(), product.getProductCost()) &&
	               Objects.equals(getProductDescription(), product.getProductDescription()) &&
	               Objects.equals(getProductCategory(), product.getProductCategory());
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(getProductId(), getProductName(), getProductCost(), getProductDescription(), getProductCategory());
	    }


}
