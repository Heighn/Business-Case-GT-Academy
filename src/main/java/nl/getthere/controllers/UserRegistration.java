package nl.getthere.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	@RequestMapping("/ingelogd")
	public String recruitersIngelogd(Model model){	
		model.addAttribute("recruiters", userRepo.findAll());
		return "recruitersIngelogd";
	}
	
	@RequestMapping("/newStudent")
	public String newStudent(){
		return "gelukt";
	}
	
	@ModelAttribute("recruiter")
	public Recruiter newRecruiter() {
	        return new Recruiter();
	}
	
	@RequestMapping(value="/recruitersReg", method=RequestMethod.POST)
	public String nieuw(@Valid Recruiter recruiter, BindingResult result){
		if(result.hasErrors()) {
			return "recruitersReg";
		}
		return "recruitersReg";
	}
	
	@RequestMapping(value="/recruitersLogin", method=RequestMethod.POST)
	public String login(String recruiterName, String recruiterPass){
		return "redirect:/ingelogd";
	}
}