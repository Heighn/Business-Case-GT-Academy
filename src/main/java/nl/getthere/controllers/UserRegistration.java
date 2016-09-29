package nl.getthere.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import nl.getthere.users.Recruiter;
import nl.getthere.users.UserRepository;

@Controller
public class UserRegistration {
	@Autowired
	private UserRepository userRepo;
		
	@RequestMapping("/recruitersReg")
	public String recuiters(Model model){		
		model.addAttribute("recruiters", userRepo.findAll());
		return "recruitersReg";
	}
	@RequestMapping("/newStudent")
	public String newStudent(){
		
		return "gelukt";
	}
	
	@RequestMapping(value="/recruitersReg", method=RequestMethod.POST)
	public String nieuw(String recruiterName, String recruiterPass){
		Recruiter recruiter = new Recruiter(recruiterName, recruiterPass);
		userRepo.save(recruiter);
		return "/recruitersReg";
	}
	
}
