package com.app.crud;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import com.app.crud.entity.User;
import com.app.crud.util.ListHelper;

/**
 * arugji CIS175 fall 2021 Oct 5
 *
 * Actual execution for application.
 */
public class ArdaCrudOperationsApplication {

	private ListHelper lh = new ListHelper();

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ArdaCrudOperationsApplication service = new ArdaCrudOperationsApplication();
		boolean isContinue = true;
		while (isContinue) {
			System.out.println(
					"\n\n----------------------------------- Welcome User Program ------------------------------------");
			System.out.println("\n\n1. Add User");
			System.out.println("2. Update User");
			System.out.println("3. Delete User");
			System.out.println("4. Show All Users");
			System.out.println("0. Exit");

			System.out.print("\n\nEnter your choice: ");
			int ch = in.nextInt();

			switch (ch) {
			case 1:
				service.add();
				break;
			case 2:
				service.update();
				break;
			case 3:
				service.delete();
				break;
			case 4:
				service.showAll();
				break;
			case 0:
				System.out.println("\n\nThanks for using our program. Good Day :)\n\n\n");
				System.exit(0);
			}
		}
	}

	public void showAll() {
		System.out.print("\n\n");
		List<User> list = lh.showAll();
		for (User u : list) {
			System.out.println(u.getId() + " --- " + u.getName());
		}
	}

	public void add() {
		Scanner addIn = new Scanner(System.in);
		System.out.print("\n\n----------------------------------- Add Details ------------------------------------");

		System.out.print("\nEnter Name: ");
		String name = addIn.nextLine();

		User usr = new User();
		usr.setName(name);

		lh.inserUser(usr);

		System.out.print("\n" + name + " saved succesfully...");
		showAll();
		System.out.print("\n\n");
	}

	public void update() {
		Scanner updateIn = new Scanner(System.in);

		System.out.print("\n\n----------------------------------- Update Details ------------------------------------");

		showAll();

		System.out.print("\n\nEnter id from above to edit: ");
		long id = updateIn.nextInt();

		if (id == 0) {
			System.out.print("\n\nId should be greater than 0.");
			return;
		}

		User usr = lh.searchById(id);

		if (Objects.isNull(usr)) {
			System.out.print("\n\nId not present in above list. Please enter valid id.");
			return;
		}

		System.out.print("\nUpdate Name: ");
		String name = updateIn.next();

		if (name != null && !name.trim().isEmpty()) {
			usr.setName(name);
		}

		lh.updateUser(usr);

		System.out.print("\n" + name + " updated succesfully...");
		showAll();
		System.out.print("\n\n");
	}

	public void delete() {
		Scanner deleteIn = new Scanner(System.in);
		System.out.print("\n\n----------------------------------- Delete Details ------------------------------------");

		showAll();

		System.out.print("\n\nEnter id from above to delete: ");
		long id = deleteIn.nextInt();

		if (id == 0) {
			System.out.print("\n\nId should be greater than 0.");
			return;
		}

		User usr = lh.searchById(id);

		if (Objects.isNull(usr)) {
			System.out.print("\n\nId not present in above list. Please enter valid id.");
			return;
		}

		System.out.print("\nAre you sure to delete " + id + "? (Y/y) : ");
		String isSure = deleteIn.next();

		if (isSure.equalsIgnoreCase("y")) {
			lh.deleteUser(usr);
			System.out.print("\n" + usr.getName() + " deleted succesfully...");
			showAll();
		} else {
			System.out.print("\n\nDelete process abort....");
		}
		System.out.print("\n\n");
	}
}
