package com.jbk.serviceIMPL;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.dao.ProductDao;
import com.jbk.model.Product;
import com.jbk.service.ProductService;

@Service
public class ProductServiceIMPL implements ProductService {

	@Autowired
	private ProductDao dao;

	@Override
	public boolean saveProduct(Product product) {

		String productId = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
		product.setProductId(Long.parseLong(productId));

		boolean isAdded = dao.saveProduct(product);

		return isAdded;
	}

	@Override
	public Product getProductById(Long productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> list = dao.getAllProducts();
		return list;
	}

}
