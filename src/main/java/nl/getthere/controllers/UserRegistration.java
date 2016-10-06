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
import org.springframework.web.context.request.WebRequest;

import javax.validation.Valid;

@Controller
public class UserRegistration {
	@Autowired
	static private StudentRepository studentRepo;
	@Autowired
	static private RecruiterRepository recruiterRepo;

	private Student currentStudent;
	private Recruiter currentRecruiter;


	@Autowired(required=true)
	private StudentMailSender studentMailSender;

	static public StudentRepository getStudentRepo(){
		return studentRepo;
	}

	static public RecruiterRepository getRecruiterRepo(){
		return recruiterRepo;
	}

	static public String findStudentPassword(String email) {
		for (Student student : studentRepo.findAll()) {
			if (student.getEmailAddress().equals(email)) {
				return student.getPassword();
			}
		}
		return "";
	}
	static public String findRecruiterPassword(String name) {
		for (Recruiter recruiter : recruiterRepo.findAll()) {
			System.out.println(recruiter.getRecruiterName());
			System.out.println(name);
			if (recruiter.getRecruiterName().equals(name)) {
				return recruiter.getRecruiterPass();
			}
		}
		return "";
	}


	static public String findFirstName(String email) {
		for (Student student : studentRepo.findAll()) {
			if (student.getEmailAddress().equals(email)) {
				return student.getFirstName();
			}
		}
		return "";
	}

	static public Student findStudent(String email) {
		for (Student student : studentRepo.findAll()) {
			if (student.getEmailAddress().equals(email)) {
				return student;
			}
		}
		return null;
	}
	static public Recruiter findRecruiter(String name) {
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

	@RequestMapping(value = "/wijzig", method = RequestMethod.GET)
	public String updateAccount(Model model) {
		model.addAttribute("firstName", currentStudent.getFirstName());
		model.addAttribute("lastName", currentStudent.getLastName());
		model.addAttribute("emailAddress", currentStudent.getEmailAddress());
		model.addAttribute("phoneNumber", currentStudent.getPhoneNumber());
		model.addAttribute("password", currentStudent.getPassword());

		// Student studentForm = currentStudent;
		Student studentForm = new Student();
		model.addAttribute("studentForm", studentForm);

		return "SignUp";
	}

	@RequestMapping(value = "/wijzig", method = RequestMethod.POST)
	public String postUpdateAccount(@Valid @ModelAttribute("studentForm") Student studentForm, Model model) {
		currentStudent = studentForm;
		model.addAttribute("firstName", currentStudent.getFirstName());
		return "LoggedIn";
	}

//	@RequestMapping(value = "/SignIn", method = RequestMethod.GET)
//	public String signIn() {
//		// studentRepo.deleteAll();
//		System.out.println("DEze methode gebruikt ie");
//		return "SignIn";
//	}

//	@RequestMapping(value = "/SignIn", method = RequestMethod.POST)
//	public String checkLogin(String email, String password, Model model) {
//		//Student Login
//		if (findStudentPassword(email).equals(password) && !findStudent(email).isInActief()) {
//			model.addAttribute("firstName", findFirstName(email));
//			model.addAttribute("message", "Welkom terug!");
//			currentStudent = findStudent(email);
//			return "LoggedIn";
//		}
//		//Recruiter Login
//		if(findRecruiterPassword(email).equals(password)){
//			model.addAttribute("firstName", email);
//			currentRecruiter = findRecruiter(email);
//			return "recruitersIngelogd";
//		}
//
//		return "SignIn";
////	}

	@RequestMapping(value = "/signUp", method = RequestMethod.GET)
	public String signUp(Model model, WebRequest webReq) {
		if(webReq.getParameter("newAccount").toString().equals("Studentaccount aanmaken")){
			System.out.println("Ik ga een nieuwe student aanmaken!");
			Student studentForm = new Student();
			model.addAttribute("studentForm", studentForm);
			return "SignUp";
		}
		else{
			Recruiter recruiterForm = new Recruiter();
			model.addAttribute("recruiterForm", recruiterForm);
			return "recruitersReg";
		}
	}

	@RequestMapping(value = "/signUp", method = RequestMethod.POST)
	public String postSignUp(@Valid @ModelAttribute("studentForm") Student studentForm, Model model) {
		if(!studentForm.getPassword().equals(studentForm.getPasswordConfirmation())){
			return "SignUp";
		}
//		studentMailSender.sendWelcomeEmail(studentForm.getFirstName(), studentForm.getEmailAddress());
		System.out.println("Ik kom in de signUpPost");
		studentRepo.save(studentForm);
		currentStudent = studentForm;
		model.addAttribute("message", "Fijn dat je je hebt ingeschreven!");
		model.addAttribute("firstName", currentStudent.getFirstName());
		return "SignIn";
	}

//*****************RECRUITERS****************

	@RequestMapping("/SendEmail")
	public String sendEmailByRecruiter(){
		return "SendEmail";
	}

	@RequestMapping(value="/SendEmail", method=RequestMethod.POST)
	public String sendEmailByRecruiterPost(String messageText, String subject, String emailAddresses){
		studentMailSender.sendEmail(messageText, subject, emailAddresses.split(", "));
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


//	@RequestMapping("/recruitersLogin")
//	public String recruitersLogin(Model model){
//		model.addAttribute("recruiters", recruiterRepo.findAll());
//		return "recruitersLogin";
//	}

	@RequestMapping("/ingelogd")
	public String recruitersIngelogd(Model model){
		model.addAttribute("recruiters", recruiterRepo.findAll());
		return "recruitersIngelogd";
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
		return "recruitersIngelogd";
//		return "recruitersReg";
	}



	@RequestMapping(value="/recruitersLogin", method=RequestMethod.POST)
	public String login(String recruiterName, String recruiterPass){
		return "redirect:/ingelogd";
	}
}