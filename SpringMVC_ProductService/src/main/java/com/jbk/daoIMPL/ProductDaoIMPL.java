package com.jbk.daoIMPL;

import javax.persistence.PersistenceException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.dao.ProductDao;
import com.jbk.entity.Product;

@Repository
public class ProductDaoIMPL implements ProductDao {
	
	@Autowired
	private SessionFactory factory;

	@Override
	public boolean addProduct(Product product) {
		boolean isAdded = false;
		try {
			Session session = factory.openSession();
			session.save(product);
			session.beginTransaction().commit();
			isAdded = true;
		} catch (PersistenceException e) {
			isAdded = false;
		} catch (Exception e) {
			e.printStackTrace();
			isAdded = false;
		}

		return isAdded;
	}

}
