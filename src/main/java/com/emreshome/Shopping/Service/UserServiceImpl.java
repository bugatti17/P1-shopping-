package com.emreshome.Shopping.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emreshome.Shopping.Entity.User;
import com.emreshome.Shopping.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
		
	}

	@Override
	public void save(User user) {
		user.setAuth(1);
		userRepository.save(user);
	
		
	}
	
	

}
