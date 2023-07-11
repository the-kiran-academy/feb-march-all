package com.jbk.serviceIMPL;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.dao.ProductDao;
import com.jbk.model.Product;
import com.jbk.service.ProductService;
import com.jbk.sorting.ProductIdComarator;
import com.jbk.sorting.ProductNameComarator;

@Service
public class ProductServiceIMPL implements ProductService {
	
	
	@Autowired
	private ProductDao dao;

	@Override
	public boolean saveProduct(Product product) {
		
		String productId = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
		product.setProductId(productId);

		return dao.saveProduct(product);
	}

	@Override
	public Product getProductById(String productId) {

		return dao.getProductById(productId);
	}

	@Override
	public List<Product> getAllProduct() {
		return dao.getAllProduct();

	}

	@Override
	public boolean deleteProductById(String productId) {
		return dao.deleteProductById(productId);
	}

	@Override
	public boolean updateProduct(Product product) {
		return dao.updateProduct(product);
	}

	@Override
	public List<Product> sortProductsById_ASC() {
		List<Product> list = getAllProduct();
		Collections.sort(list, new ProductIdComarator());
		return list;
	}

	@Override
	public List<Product> sortProductsByName_DESC() {
		List<Product> list = getAllProduct();
		//list.sort(Comparator.comparing(Product::getProductName));
		Collections.sort(list, new ProductNameComarator());
		return list;
	}

	@Override
	public Product getMaxPriceProducts() {

		List<Product> list = getAllProduct();
		Product product = list.stream().max(Comparator.comparingDouble(Product::getProductPrice)).get();
		
		return product;
	}

	@Override
	public double countSumOfProductPrice() {
		List<Product> list = getAllProduct();
		Double sumOfProductPrice = list.stream().map(product -> product.getProductPrice()).reduce(0d,
				(sum, price) -> sum + price);
		return sumOfProductPrice;
	}

	@Override
	public int getTotalCountOfProducts() {
		
		return getAllProduct().size();
	}

}
