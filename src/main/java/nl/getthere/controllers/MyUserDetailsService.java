package nl.getthere.controllers;

import nl.getthere.users.Recruiter;
import nl.getthere.users.RecruiterRepository;
import nl.getthere.users.Student;
import nl.getthere.users.StudentRepository;
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
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user;
		try {
			Student student = studentRepo.findByEmailAddress(username);


			ArrayList<SimpleGrantedAuthority> authorityCollection = new ArrayList<SimpleGrantedAuthority>();
			authorityCollection.add(student.getUserProfile().getGrantedAuthority());
			user = new User(student.getEmailAddress(), student.getUserProfile().getPassword(), authorityCollection);
		}catch(Exception e){
			Recruiter recruiter = recruiterRepo.findByRecruiterName(username);

			ArrayList<SimpleGrantedAuthority> authorityCollection = new ArrayList<SimpleGrantedAuthority>();
			authorityCollection.add(recruiter.getUserProfile().getGrantedAuthority());
			user = new User(recruiter.getRecruiterName(), recruiter.getUserProfile().getPassword(), authorityCollection);
		}

		return user;
	}
}
