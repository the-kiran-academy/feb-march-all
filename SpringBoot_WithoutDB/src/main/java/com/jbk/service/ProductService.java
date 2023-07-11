package com.jbk.service;

import java.util.List;

import com.jbk.model.Product;

public interface ProductService {
	
	public boolean saveProduct(Product product);
	public Product getProductById(Long productId);
	public List<Product> getAllProducts();

}
