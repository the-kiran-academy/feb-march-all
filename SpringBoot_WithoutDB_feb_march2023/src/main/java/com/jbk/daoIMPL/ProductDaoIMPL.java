package com.jbk.daoIMPL;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.dao.ProductDao;
import com.jbk.model.Product;

@Repository
public class ProductDaoIMPL implements ProductDao {

	List<Product> list = new ArrayList<>();

	public ProductDaoIMPL() {
		list.add(new Product("1", "aaa", 101, 101, 10, 50));
		list.add(new Product("2", "bbb", 101, 101, 12, 60));
		list.add(new Product("3", "ccc", 101, 102, 100, 500));
	}

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
	public Product getProductById(String productId) { // 11,22,33,44,55,66 in=22
		Product product = null;
		for (Product dbproduct : list) {
			if (dbproduct.getProductId().equals(productId)) {
				product = dbproduct;
				break;
			}
		}
		return product;

	}

	@Override
	public List<Product> getAllProduct() {
		return list;

	}

	@Override
	public boolean deleteProductById(String productId) {
		boolean isDeleted = false;
		for (Product dbproduct : list) {
			if (dbproduct.getProductId().equals(productId)) {
				list.remove(dbproduct);
				isDeleted = true;
				break;
			}
		}
		return isDeleted;
	}

	@Override
	public boolean updateProduct(Product product) {
		boolean isUpdated = false;
		for (Product dbproduct : list) {
			if (dbproduct.getProductId().equals(product.getProductId())) {
				list.set(list.indexOf(dbproduct), product);
				isUpdated = true;
				break;
			}
		}

		return isUpdated;
	}

}
