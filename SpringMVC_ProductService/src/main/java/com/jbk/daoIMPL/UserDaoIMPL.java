package com.jbk.daoIMPL;

import javax.persistence.PersistenceException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.dao.UserDao;
import com.jbk.entity.User;

@Repository
public class UserDaoIMPL implements UserDao {

	@Autowired
	private SessionFactory factory;

	@Override
	public Boolean addUser(User user) {
		boolean isAdded = false;
		Session session = null;
		try {
			session = factory.openSession();
			session.save(user);
			session.beginTransaction().commit();
			isAdded = true;
		} catch (PersistenceException e) {
			isAdded = false;
		} catch (Exception e) {
			e.printStackTrace();
			isAdded = false;
		} finally {
			session.close();
		}

		return isAdded;
	}

	@Override
	public Boolean updateUser(User user) {
		boolean isUpdated = false;
		Session session = null;
		try {
			session = factory.openSession();
			session.update(user);
			session.beginTransaction().commit();
			isUpdated = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return isUpdated;
	}

	@Override
	public User getUserById(String username) {
		Session session = null;
		session = factory.openSession();
		User user = session.get(User.class, username);

		return user;
	}

}
