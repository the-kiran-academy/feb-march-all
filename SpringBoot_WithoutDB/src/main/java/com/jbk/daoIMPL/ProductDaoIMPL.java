package com.jbk.daoIMPL;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.jbk.dao.ProductDao;
import com.jbk.model.Product;

@Repository
public class ProductDaoIMPL implements ProductDao {
	
	List<Product> list = new ArrayList<>();

	@Override
	public boolean saveProduct(Product product) {
		boolean isExists=false;
		for (Product dbproduct : list) {
			if(dbproduct.getProductName().equalsIgnoreCase(product.getProductName())) {
				isExists=true;
				break;
			}
		}
		
		if(!isExists) {
			list.add(product);
			return true;
		}else {
			return false;
		}
	}
	
	

	@Override
	public Product getProductById(Long productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getAllProducts() {
		
		return list;
	}

}
