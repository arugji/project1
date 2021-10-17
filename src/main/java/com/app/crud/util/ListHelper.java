package com.app.crud.util;

import java.util.List;

import javax.persistence.EntityManager;

import com.app.crud.entity.User;

public class ListHelper {

	public void inserUser(User obj) {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		if (!entityManager.getTransaction().isActive())
			entityManager.getTransaction().begin();
		entityManager.persist(obj);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public void updateUser(User obj) {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(obj);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public User searchById(long id) {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		entityManager.getTransaction().begin();
		User usr = entityManager.find(User.class, id);
		entityManager.getTransaction().commit();
		entityManager.close();
		return usr;
	}

	public void deleteUser(User obj) {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		entityManager.getTransaction().begin();
		if (!entityManager.contains(obj)) {
			obj = entityManager.merge(obj);
		}
		entityManager.remove(obj);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public List<User> showAll() {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		entityManager.getTransaction().begin();
		@SuppressWarnings("unchecked")
		List<User> list = (List<User>) entityManager.createQuery("SELECT u FROM User u").getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();
		return list;
	}

}
