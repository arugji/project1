package com.app.crud;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Assert;
import org.junit.Test;

import com.app.crud.entity.User;
import com.app.crud.util.EntityManagerUtil;

public class ArdaCrudOperationsApplicationTests {

	@PersistenceContext
	private EntityManager entityManager = EntityManagerUtil.getEntityManager();

	@Test
	public void contextLoads() {
		User usr = new User();
		usr.setName("Arda");
		entityManager.getTransaction().begin();
		entityManager.persist(usr);
		entityManager.getTransaction().commit();
		Assert.assertNotEquals(0, usr.getId().longValue());
	}

}
