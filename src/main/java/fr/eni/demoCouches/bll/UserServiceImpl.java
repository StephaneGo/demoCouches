package fr.eni.demoCouches.bll;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.eni.demoCouches.bo.User;
import fr.eni.demoCouches.dal.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	private UserRepository userRepo;
	
	public UserServiceImpl(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	public List<User> getUsersByAge(int age){
		return this.userRepo.getUsersByAge(age);
	}

	@Override
	public void saveUser(User user) {
		this.userRepo.saveUser(user);
		
	}
}
