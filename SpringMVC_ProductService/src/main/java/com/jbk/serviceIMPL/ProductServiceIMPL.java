package com.jbk.serviceIMPL;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.dao.ProductDao;
import com.jbk.entity.Product;
import com.jbk.service.ProductService;

@Service
public class ProductServiceIMPL implements ProductService {

	@Autowired
	private ProductDao productDao;

	@Override
	public boolean addProduct(Product product) {
		String id = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new java.util.Date());
		product.setProductId(Long.parseLong(id));
		return productDao.addProduct(product);
	}

}
