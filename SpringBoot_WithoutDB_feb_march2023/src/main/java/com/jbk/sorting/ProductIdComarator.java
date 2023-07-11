package com.jbk.sorting;

import java.util.Comparator;

import com.jbk.model.Product;

public class ProductIdComarator implements Comparator<Product> {

	@Override
	public int compare(Product p1, Product p2) {
		
		return p1.getProductId().compareTo(p2.getProductId());
	}

	
}
