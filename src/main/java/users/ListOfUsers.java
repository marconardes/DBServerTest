package users;

import java.util.ArrayList;
import java.util.List;

public class ListOfUsers {

	List<User> users;
	public ListOfUsers() {
		users = new ArrayList<User>();
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public void populate() {
		users.add(new User(1,"Pessoa1", "1", false));
		users.add(new User(2,"Pessoa2", "2", false));
		users.add(new User(3,"Pessoa3", "3", false));
		users.add(new User(4,"Pessoa4", "4", false));
		users.add(new User(5,"Pessoa5", "5", false));
		users.add(new User(6,"Pessoa6", "6", false));
		users.add(new User(7,"Pessoa7", "7", false));
		users.add(new User(8,"Pessoa8", "8", false));
		users.add(new User(9,"Pessoa9", "9", false));
		users.add(new User(10,"Pessoa10", "10", false));
		
	}

	public User selectUser(int id) {
		for (User user : users) {
			if(user.getId() ==id)
			{
				return user;
			}
		}
		return null;
	}

}
