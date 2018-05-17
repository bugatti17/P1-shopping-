package com.emreshome.Shopping.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emreshome.Shopping.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
		User findByUsername(String username);
}
