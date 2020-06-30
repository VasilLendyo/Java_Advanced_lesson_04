package servlets;

import java.util.ArrayList;
import java.util.List;

public class UserService {

	private List<User> users = new ArrayList<User>();
	private static UserService userService;
	
	private UserService() {}

	public static UserService getUserService() {
		if(userService==null) {
			userService = new UserService();
		}
		return userService;
	}

	public List<User> getUsers() {
		return users;
	}
	
	public void saveUser(User user) {
		users.add(user);
	}
	
	public User getUser(String login) {
		return users.stream().filter(user->user.getLogin().equals(login)).findAny().orElse(null);
	}
}
