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
	public String recruiters(Model model){		
		model.addAttribute("recruiters", userRepo.findAll());
		return "/recruitersReg";
	}
	
	@RequestMapping("/recruitersList")
	public String recruitersList(Model model){	
		model.addAttribute("recruiters", userRepo.findAll());
		return "recruitersList";
	}
	
	@RequestMapping("/recruitersLogin")
	public String recruitersLogin(Model model){	
		model.addAttribute("recruiters", userRepo.findAll());
		return "recruitersLogin";
	}
	
	@RequestMapping("/newStudent")
	public String newStudent(){
		
		return "gelukt";
	}
	
	@RequestMapping(value="/recruitersReg", method=RequestMethod.POST)
	public String nieuw(String recruiterName, String recruiterPass, String confirm){
		if ( (recruiterPass.equals(confirm) && !(recruiterPass.isEmpty())) && !(recruiterName.isEmpty()) ) {
			Recruiter recruiter = new Recruiter(recruiterName, recruiterPass, confirm);
			userRepo.save(recruiter);
			return "redirect:/recruitersList";
		}
		return "redirect:/recruitersReg";
	}
}
