package nl.getthere.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import nl.getthere.users.StudentRepository;


@Service
public class MyUserDetailsService implements UserDetailsService {
	@Autowired
	private StudentRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		System.out.println("LoadByUserName method: " + username);
		
		UserDetails uD = repo.findByEmailAddress(username);
		System.out.println("UD: " + uD);
		return uD;
	}

}
