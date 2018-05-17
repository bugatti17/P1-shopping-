package com.emreshome.Shopping.Service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emreshome.Shopping.Entity.User;
import com.emreshome.Shopping.repositories.UserRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	@Autowired
    private UserRepository userRepository;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		User u=userRepository.findByUsername(arg0);
		
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		if(u.getAuth()==1){
			grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		}
		else{
			grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));

			grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		}
		return new org.springframework.security.core.userdetails.User(u.getUsername(), u.getPassword(), grantedAuthorities);
	}

}
