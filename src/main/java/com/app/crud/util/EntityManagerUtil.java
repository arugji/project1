package com.app.crud.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * arugji 
 * CIS175 fall 2021
 * Oct 5
 */
public class EntityManagerUtil {
	private static final EntityManagerFactory entityManagerFactory;
	static {
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("crud-app");
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static EntityManager getEntityManager() {
		return entityManagerFactory.createEntityManager();
	}
}
