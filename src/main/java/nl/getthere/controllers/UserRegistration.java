package nl.getthere.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import nl.getthere.services.StudentMailSender;
import nl.getthere.users.Recruiter;
import nl.getthere.users.RecruiterRepository;
import nl.getthere.users.Student;
import nl.getthere.users.StudentRepository;

@Controller
public class UserRegistration {
	@Autowired
	private StudentRepository studentRepo;
	@Autowired
	private RecruiterRepository recruiterRepo;
	
	private Student currentStudent;
	@SuppressWarnings("unused")
	private Recruiter currentRecruiter;
	
//	@Autowired
//	private JavaMailSender javaMailSender;
	
	@Autowired(required=true)
	private StudentMailSender studentMailSender;

	private String findStudentPassword(String email) {
		for (Student student : studentRepo.findAll()) {
			if (student.getEmailAddress().equals(email)) {
				return student.getPassword();
			}
		}
		return "";
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

	private String findFirstName(String email) {
		for (Student student : studentRepo.findAll()) {
			if (student.getEmailAddress().equals(email)) {
				return student.getFirstName();
			}
		}
		return "";
	}

	private Student findStudent(String email) {
		for (Student student : studentRepo.findAll()) {
			if (student.getEmailAddress().equals(email)) {
				return student;
			}
		}
		return null;
	}

	private Recruiter findRecruiter(String name) {
		for (Recruiter recruiter : recruiterRepo.findAll()) {
			if (recruiter.getRecruiterName().equals(name)) {
				return recruiter;
			}
		}
		return null;
	}

	@RequestMapping("/inactief")
	public String deleteAccount() {
		currentStudent.setInActief(true);
		return "SignIn";
	}

	@RequestMapping(value = "/profiel", method = RequestMethod.GET)
	public String updateAccount(Model model) {
		model.addAttribute("firstName", currentStudent.getFirstName());
		model.addAttribute("lastName", currentStudent.getLastName());
		model.addAttribute("emailAddress", currentStudent.getEmailAddress());
		model.addAttribute("phoneNumber", currentStudent.getPhoneNumber());
		model.addAttribute("password", currentStudent.getPassword());

		// Student currentStudent = currentStudent;
		Student currentStudent = new Student();
		model.addAttribute("currentStudent", currentStudent);

		return "profiel";
	}

	@RequestMapping(value = "/profiel", method = RequestMethod.POST)
	public String postUpdateAccount(@Valid @ModelAttribute("currentStudent") Student currentStudent, Model model) {
		model.addAttribute("firstName", currentStudent.getFirstName());
		return "LoggedIn";
	}

	@RequestMapping(value = "/inloggen", method = RequestMethod.GET)
	public String profiel() {
		// studentRepo.deleteAll();
		return "inloggen";
	}
	
	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public String error() {
		return "error";
	}

	@RequestMapping(value = "/inloggen", method = RequestMethod.POST)
	public String checkinloggen(String email, String password, Model model) {
		//Student inloggen
		if (findStudentPassword(email).equals(password) && !findStudent(email).isInActief()) {
			model.addAttribute("firstName", findFirstName(email));
			model.addAttribute("message", "profiel terug!");
			currentStudent = findStudent(email);
			model.addAttribute("currentStudent", currentStudent);
			return "profiel";
		}
		//Recruiter inloggen
		if(findRecruiterPassword(email).equals(password)){
			model.addAttribute("firstName", email);
			currentRecruiter = findRecruiter(email);
			return "admin";
		}
		
		return "inloggen";
	}

	@RequestMapping(value = "/registreren", method = RequestMethod.GET)
	public String registreren(Model model) {
		Student currentStudent = new Student();
		model.addAttribute("currentStudent", currentStudent);
		return "registreren";
	}
	
	@RequestMapping(value = "/registreren", method = RequestMethod.POST)
	public String postregistreren(@Valid @ModelAttribute("currentStudent") Student currentStudent, Model model) {
		if(!currentStudent.getPassword().equals(currentStudent.getPasswordConfirmation())){
			return "registreren";
		}
//		studentMailSender.sendWelcomeEmail(currentStudent.getFirstName(), currentStudent.getEmailAddress());
		studentRepo.save(currentStudent);
		model.addAttribute("firstName", currentStudent.getFirstName());
		model.addAttribute("message", "Gefeliciteerd, je hebt nu een profiel bij Get There! Je bent automatisch ingelogd op je persoonlijke account. Wij verzoeken je vriendelijk de gegevens over je opleiding in te vullen en aan te geven waar je interesses liggen. Daarnaast kun je ook je CV uploaden, maar voel je niet verplicht!");
		return "profiel";
	}
		
//*****************RECRUITERS****************
	
	@RequestMapping("/sendEmail")
	public String sendEmailByRecruiter(){
		return "sendEmail";
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
	
	
//	@RequestMapping("/recruitersinloggen")
//	public String recruitersinloggen(Model model){	
//		model.addAttribute("recruiters", recruiterRepo.findAll());
//		return "recruitersinloggen";
//	}
	
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

	@RequestMapping(value="/recruitersinloggen", method=RequestMethod.POST)
	public String inloggen(String recruiterName, String recruiterPass){
		return "redirect:/admin";
	}
}