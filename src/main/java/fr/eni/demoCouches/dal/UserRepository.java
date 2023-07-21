package fr.eni.demoCouches.dal;

import java.util.List;

import fr.eni.demoCouches.bo.User;

public interface UserRepository {
	public List<User> getUsersByAge(int age);

	public void saveUser(User user);
}
