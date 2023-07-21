package fr.eni.demoCouches.bll;

import java.util.List;

import fr.eni.demoCouches.bo.User;

public interface UserService {
	public List<User> getUsersByAge(int age);

	public void saveUser(User user);
}
