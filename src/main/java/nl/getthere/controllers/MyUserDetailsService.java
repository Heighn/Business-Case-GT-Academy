package nl.getthere.controllers;

import nl.getthere.users.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MyUserDetailsService implements UserDetailsService {
	@Autowired
	private StudentRepository studentRepo;
	@Autowired
	private RecruiterRepository recruiterRepo;
	@Autowired
	private UserProfileRepository userProfileRepo;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user;
		UserProfile userProfile = userProfileRepo.findByUserName(userName);
		ArrayList<SimpleGrantedAuthority> authorityCollection = new ArrayList<SimpleGrantedAuthority>();
		authorityCollection.add(userProfile.getGrantedAuthority());
		user = new User(userProfile.getUserName(), userProfile.getPasswordHash(), authorityCollection);

		return user;
	}
}
