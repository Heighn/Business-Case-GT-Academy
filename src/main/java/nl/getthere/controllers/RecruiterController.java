package nl.getthere.controllers;

import nl.getthere.services.StudentMailSender;
import nl.getthere.users.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
@RequestMapping("/recruiter")
public class RecruiterController {
	@Autowired
	private RecruiterRepository recruiterRepo;
	@Autowired
	private StudentRepository studentRepo;
	@Autowired
	private UserProfileRepository userProfileRepo;
	@Autowired
	private StudentMailSender studentMailSender;

	@RequestMapping("/searchStudent")
	public @ResponseBody
	String searchStudent(String zoekterm) {
		System.out.println("Zoekterm: " + zoekterm);

		try {
			String findByFirstName = studentRepo.findByFirstName(zoekterm).toString();
			if (findByFirstName != null) {
				return findByFirstName;
			}
		} catch (NullPointerException nPE) {
			System.out.println("Eerste NULLPOINTER!");
			try {
				String findByLastName = studentRepo.findByLastName(zoekterm).toString();
				if (findByLastName != null) {
					return findByLastName;
				}
			} catch (NullPointerException nPE2) {
				String findByFullName = findByFullName(zoekterm);
				if (findByFullName != null) {
					return findByFullName;
				}
			}
		}
		return "";
	}

	public String findByFullName(String fullName){
		Iterable<Student> all = studentRepo.findAll();
		return StreamSupport.stream(all.spliterator(), false).filter(s -> s.getFullName().contains(fullName)).collect(Collectors.toList()).toString();
	}


	private String findRecruiterPassword(String name) {
		for (Recruiter recruiter : recruiterRepo.findAll()) {
			System.out.println(recruiter.getRecruiterName());
			System.out.println(name);
			if (recruiter.getRecruiterName().equals(name)) {
				return recruiter.getRecruiterPass();
			}
		}
		return "";
	}


	private Recruiter findRecruiter(String name) {
		for (Recruiter recruiter : recruiterRepo.findAll()) {
			if (recruiter.getRecruiterName().equals(name)) {
				return recruiter;
			}
		}
		return null;
	}

	@RequestMapping(value = "/recruitersReg", method = RequestMethod.GET)
	public String registreren(Model model, WebRequest webReq) {
		Recruiter recruiterForm = new Recruiter();
		model.addAttribute("recruiterForm", recruiterForm);
		return "recruitersReg";
	}
	@RequestMapping(value = "/recruitersReg", method = RequestMethod.POST)
	public String registrerenPost(@Valid @ModelAttribute("recruiterForm") Recruiter recruiterForm, Model model){
		if(recruiterRepo.findByRecruiterName(recruiterForm.getRecruiterName()) == null) {
			UserProfile userProfile = new UserProfile();
			userProfile.setUserName(recruiterForm.getRecruiterName());
			userProfile.setPassword(recruiterForm.getRecruiterPass());
			userProfile.changeRole("recruiter");
			recruiterRepo.save(recruiterForm);
			userProfileRepo.save(userProfile);
			model.addAttribute("recruiterName", userProfile.getUserName());
			return "admin";
		}
		model.addAttribute("errorMessage", "Er bestaat al een account met deze gebruikersnaam!");
		return "recruitersReg";
	}

//	@RequestMapping(value = "/inloggen", method = RequestMethod.POST)
//	public String checkinloggen(String email, String password, Model model) {
//		//Recruiter inloggen
//		if(findRecruiterPassword(email).equals(password)){
//			model.addAttribute("firstName", email);
//			currentRecruiter = findRecruiter(email);
//			return "admin";
//		}
//		return "inloggen";
//	}

	@RequestMapping("/SendEmail")
	public String sendEmailByRecruiter(){
		return "sendEmail";
	}

	@RequestMapping(value="/SendEmail", method=RequestMethod.POST)
	public String sendEmailByRecruiterPost(String messageText, String subject, String emailAddresses) {
		studentMailSender.sendEmail(messageText, subject, emailAddresses.split(", "));
		return "index";
	}
	
	@RequestMapping(value="/sendEmail", method=RequestMethod.POST)
	public String sendEmailByRecruiterPost(String messageText, String emailAddress){
		System.out.println("EMAIL: " + emailAddress);
		studentMailSender.sendEmail(messageText, emailAddress);
		return "recruitersIngelogd";
	}

	@RequestMapping("/recruitersList")
	public String recruitersList(Model model){
		model.addAttribute("recruiters", recruiterRepo.findAll());
		return "recruitersList";
	}

	@RequestMapping("/StudentList")
	public String studentList(Model model){
		model.addAttribute("students", studentRepo.findAll());
		return "StudentList";
	}
	@RequestMapping("/DeleteStudent")
	public String deleteStudent(Model model){
		model.addAttribute("students", studentRepo.findAll());
		return "DeleteStudent";
	}
	@RequestMapping(value="/DeleteStudent",method=RequestMethod.POST)
	public String deleteStudentPost(Model model, String emai){

		return "DeleteStudent";
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {
		return "index";
	}

	@RequestMapping("/ingelogd")
	public String recruitersIngelogd(Model model){
		model.addAttribute("recruiters", recruiterRepo.findAll());
		return "admin";
	}

	@ModelAttribute("recruiter")
	public Recruiter newRecruiter() {
	        return new Recruiter();
	}



	@RequestMapping(value="/recruitersLogin", method=RequestMethod.POST)
	public String login(String recruiterName, String recruiterPass) {
		return "redirect:/ingelogd";
	}

	@RequestMapping(value="/recruitersinloggen", method=RequestMethod.POST)
	public String inloggen(String recruiterName, String recruiterPass){
		return "redirect:/admin";
	}

	@RequestMapping("/*")
	public String notFound(HttpServletResponse resp){
		resp.setStatus(404);
		return "404";
	}
}