package com.emreshome.Shopping.Service;

import com.emreshome.Shopping.Entity.User;

public interface UserService {
		User findByUsername(String username);
		void save(User user);
		
}
