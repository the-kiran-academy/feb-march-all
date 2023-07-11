package com.jbk.dao;

import java.util.List;

import com.jbk.model.Product;

public interface ProductDao {
	public boolean saveProduct(Product product);

	public Product getProductById(Long productId);

	public List<Product> getAllProducts();

}
