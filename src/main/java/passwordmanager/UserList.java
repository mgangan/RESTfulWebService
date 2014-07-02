package passwordmanager;

import java.util.ArrayList;

// import Entry
// import DbHelper

public class UserList {
	
	private ArrayList<User> users;

	public UserList() {
		this.users = new ArrayList<User>();
		users.add(new User(1, "User1", "Pass1"));
		users.add(new User(2, "Tzeench", "nfdjkbsdf723grb23"));
		users.add(new User(3, "User3", "Pass3"));
	}

	// public boolean create(String name, String password) {
	// 	Entry user = new Entry().setName(name).setPassword(password);
	// 	return DbHelper.createEntry(user);
	// }

	// public boolean update(String name, String password) {
	// 	Entry user = new Entry().setName(name).setPassword(password);
	// 	return DbHelper.updateEntry(user);
	// }

	// public boolean delete(String name) {
	// 	return DbHelper.deleteEntry(name);
	// }

	// public ArrayList<Entry> getUsers() {
	// 	return DbHelper.getAllEntries();
	// }

	public boolean create(String name, String password) {
		int num = users.size() + 1;
		User newUser = new User(num, name, password);
		for (User currentUser : users)
			if (currentUser.getName().equals(name))
				return false;
		return users.add(newUser);
	}

	public boolean update(String name, String password) {
		for (User currentUser : users)
			if (currentUser.getName().equals(name)) {
				currentUser.setPassword(password);
				return true;
			}
		return false;
	}

	public boolean delete(String name) {
		for (User currentUser : users)
			if (currentUser.getName().equals(name)) {
				users.remove(users.indexOf(currentUser));
				return true;
			}
		return false;
	}

	public ArrayList<User> getUsers() {
		return users;
	}
}

