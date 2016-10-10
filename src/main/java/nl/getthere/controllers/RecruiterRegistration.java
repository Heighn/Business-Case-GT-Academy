package nl.getthere.controllers;

import nl.getthere.services.StudentMailSender;
import nl.getthere.users.Recruiter;
import nl.getthere.users.RecruiterRepository;
import nl.getthere.users.Student;
import nl.getthere.users.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import javax.validation.Valid;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
@RequestMapping("/recruiter")
public class RecruiterRegistration {
	@Autowired
	private RecruiterRepository recruiterRepo;
	@Autowired
	private StudentRepository studentRepo;

	private Student currentStudent;
	private Recruiter currentRecruiter;


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

	@RequestMapping(value = "/signUp", method = RequestMethod.GET)
	public String signUp(Model model, WebRequest webReq) {
		Recruiter recruiterForm = new Recruiter();
		model.addAttribute("recruiterForm", recruiterForm);
		return "recruitersReg";
	}

	@RequestMapping(value = "/inloggen", method = RequestMethod.POST)
	public String checkinloggen(String email, String password, Model model) {
		//Recruiter inloggen
		if(findRecruiterPassword(email).equals(password)){
			model.addAttribute("firstName", email);
			currentRecruiter = findRecruiter(email);
			return "admin";
		}
		return "inloggen";
	}

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

	@RequestMapping("/recruitersReg")
	public String recruiters(Model model){
		model.addAttribute("recruiters", recruiterRepo.findAll());
		return "/recruitersReg";
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

	@RequestMapping(value="/recruitersReg", method=RequestMethod.POST)
	public String nieuw(@Valid Recruiter recruiter, BindingResult result, Model model){
		if(result.hasErrors()) {
			return "recruitersReg";
		}
		recruiterRepo.save(recruiter);
		model.addAttribute("recruiterName", recruiter.getRecruiterName());
		return "admin";
//		return "recruitersReg";
	}

	@RequestMapping(value="/recruitersLogin", method=RequestMethod.POST)
	public String login(String recruiterName, String recruiterPass) {
		return "redirect:/ingelogd";
	}

	@RequestMapping(value="/recruitersinloggen", method=RequestMethod.POST)
	public String inloggen(String recruiterName, String recruiterPass){
		return "redirect:/admin";
	}
}