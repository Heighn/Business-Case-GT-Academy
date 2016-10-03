package nl.getthere.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import nl.getthere.contact.StudentMailSender;
import nl.getthere.users.Student;
import nl.getthere.users.StudentRepository;

@Controller
public class UserRegistration {
	@Autowired
	private StudentRepository studentRepo;
	private Student currentStudent;
	
	@Autowired
	private StudentMailSender mailSender;

	private String findPassword(String email) {
		for (Student student : studentRepo.findAll()) {
			if (student.getEmailAddress().equals(email)) {
				return student.getPassword();
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

	@RequestMapping(value = "/welkom", method = RequestMethod.GET)
	public String welkom() {
		mailSender.sendEmail("Hoi", "heindehaan@gmail.com");
		// studentRepo.deleteAll();
		return "SignIn";
	}

	@RequestMapping(value = "/welkom", method = RequestMethod.POST)
	public String checkLogin(String email, String password, Model model) {
		if (findPassword(email).equals(password) && !findStudent(email).isInActief()) {
			model.addAttribute("firstName", findFirstName(email));
			model.addAttribute("message", "Welkom terug!");
			currentStudent = findStudent(email);
			return "LoggedIn";
		}
		return "SignIn";
	}

	@RequestMapping(value = "/signUp", method = RequestMethod.GET)
	public String signUp(Model model) {
		Student studentForm = new Student();
		model.addAttribute("studentForm", studentForm);
		return "SignUp";
	}
	
	@RequestMapping(value = "/signUp", method = RequestMethod.POST)
	public String postSignUp(@Valid @ModelAttribute("studentForm") Student studentForm, Model model) {
		if(!studentForm.getPassword().equals(studentForm.getPasswordConfirmation())){
			return "signUp";
		}
//		studentMailSender.sendWelcomeEmail(studentForm.getFirstName(), studentForm.getEmailAddress());
		
		studentRepo.save(studentForm);
		currentStudent = studentForm;
		model.addAttribute("message", "Fijn dat je je hebt ingeschreven!");
		model.addAttribute("firstName", currentStudent.getFirstName());
		return "LoggedIn";
	}
}