package com.jbk.model;

import com.jbk.entity.Product;

public class Product_Supplier_Category {
	
	private Product product;
	private Supplier supplier;
	private Category category;
	
	
	public Product_Supplier_Category() {
		// TODO Auto-generated constructor stub
	}


	public Product_Supplier_Category(Product product, Supplier supplier, Category category) {
		super();
		this.product = product;
		this.supplier = supplier;
		this.category = category;
	}


	public Product getProduct() {
		return product;
	}


	public Supplier getSupplier() {
		return supplier;
	}


	public Category getCategory() {
		return category;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}


	public void setCategory(Category category) {
		this.category = category;
	}
	
	
	

}
