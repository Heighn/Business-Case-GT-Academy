package nl.getthere.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import nl.getthere.users.Recruiter;
import nl.getthere.users.Student;
import nl.getthere.users.UserRepository;

@Controller
public class UserRegistration {
	@Autowired
	private UserRepository userRepo;
		
	@RequestMapping("/welkom")
	public String newRecruiter(){		
		System.out.println("Dit lukt nog net");
		Recruiter recruiter = new Recruiter();
		recruiter.setName("Marieke");
		recruiter.setPassword("Lokhorst");
//		recruiter.setId(new Long(1));
		System.out.println(recruiter.getId());
		userRepo.save(recruiter);	
		return "welkom";
	}
	@RequestMapping("/newStudent")
	public String newStudent(){
		Student newStudent = new Student();
		String name = "Pieter";
		newStudent.setName(name);
		return "test";
	}
}
