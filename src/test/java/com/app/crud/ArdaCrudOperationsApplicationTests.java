package com.app.crud;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.app.crud.entity.User;
import com.app.crud.util.ListHelper;

public class ArdaCrudOperationsApplicationTests {

	@Test
	public void inserData() {
		User usr = new User();
		usr.setName("Arda");
		ListHelper lh = new ListHelper();
		lh.inserUser(usr);
		Assert.assertNotEquals(0, usr.getId().longValue());
	}

	@Test
	public void updateData() {
		User usr = new User();
		usr.setName("Arda");
		ListHelper lh = new ListHelper();
		lh.inserUser(usr);
		usr.setName("Arda Rugji");
		lh.updateUser(usr);
		Assert.assertNotEquals(0, usr.getId().longValue());
	}

	@Test
	public void showAllData() {
		User usr = new User();
		usr.setName("Arda");
		ListHelper lh = new ListHelper();
		lh.inserUser(usr);
		List<User> list = lh.showAll();
		Assert.assertNotEquals(0, list.size());
	}

	@Test
	public void deleteData() {
		User usr = new User();
		usr.setName("Arda");
		ListHelper lh = new ListHelper();
		lh.inserUser(usr);
		lh.deleteUser(usr);
	}

}
