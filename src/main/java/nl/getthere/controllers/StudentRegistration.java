package nl.getthere.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import nl.getthere.users.Student;
import nl.getthere.users.StudentRepository;

@Controller
@RequestMapping("/student")
public class StudentRegistration {
	@Autowired
	private StudentRepository studentRepo;

	private Student currentStudent;
	
//	@Autowired
//	private JavaMailSender javaMailSender;

	private String findStudentPassword(String email) {
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
		return "inloggen";
	}

	@RequestMapping(value = "/profiel", method = RequestMethod.GET)
	public String updateAccount(Model model) {
		model.addAttribute("firstName", currentStudent.getFirstName());
		model.addAttribute("lastName", currentStudent.getLastName());
		model.addAttribute("emailAddress", currentStudent.getEmailAddress());
		model.addAttribute("phoneNumber", currentStudent.getPhoneNumber());
		model.addAttribute("password", currentStudent.getPassword());
		Student currentStudent = new Student();
		model.addAttribute("currentStudent", currentStudent);
		return "profiel";
	}

	@RequestMapping(value = "/profiel", method = RequestMethod.POST)
	public String postUpdateAccount(@Valid @ModelAttribute("currentStudent") Student currentStudent, Model model) {
		model.addAttribute("firstName", currentStudent.getFirstName());
		return "profiel";
	}

//	@RequestMapping(value = "/inloggen", method = RequestMethod.GET)
//	public String profiel(Model model) {
//		// studentRepo.deleteAll();
//		model.addAttribute("shaker", false);
//		return "inloggen";
//	}

//	@RequestMapping(value = "/signUp", method = RequestMethod.GET)
//	public String signUp(Model model, WebRequest webReq) {
//		if(webReq.getParameter("newAccount").toString().equals("Studentaccount aanmaken")) {
//			System.out.println("Ik ga een nieuwe student aanmaken!");
//			Student studentForm = new Student();
//			model.addAttribute("studentForm", studentForm);
//			return "inloggen";
//		}
//		return "signUp";
//	}
//
//	@RequestMapping(value = "/signUp", method = RequestMethod.POST)
//	public String postSignUp(@Valid @ModelAttribute("studentForm") Student studentForm, BindingResult bindingResult, Model model) {
////		if(!studentForm.getPassword().equals(studentForm.getPasswordConfirmation())){
////			return "SignUp";
////		}
////		studentMailSender.sendWelcomeEmail(studentForm.getFirstName(), studentForm.getEmailAddress());
//		System.out.println("Ik kom in de signUpPost");
//		currentStudent = studentForm;
//		studentRepo.save(studentForm);
//
//		model.addAttribute("message", "Fijn dat je je hebt ingeschreven!");
//		model.addAttribute("firstName", currentStudent.getFirstName());
//		return "SignIn";
//	}

//	@RequestMapping(value = "/inloggen", method = RequestMethod.POST)
//	public String checkinloggen(String email, String password, Model model) {
//		//Student inloggen
//		if((email == null || email.isEmpty()) || 
//				(password == null || password.isEmpty())) {
//			model.addAttribute("shaker", true);
//			return "inloggen";
//			} else {
//				if (findStudentPassword(email).equals(password) && !findStudent(email).isInActief()) {
//					model.addAttribute("firstName", findFirstName(email));
//					currentStudent = findStudent(email);
//					model.addAttribute("currentStudent", currentStudent);
//					return "redirect:/profiel";
//			}
//		}
//		model.addAttribute("shaker", true);
//		return "inloggen";
//	}

	//		//Recruiter inloggen
//		if(findRecruiterPassword(email).equals(password)){
//			model.addAttribute("firstName", email);
//			currentRecruiter = findRecruiter(email);
//			return "admin";
//		}
//		return "inloggen";
//	}

	@RequestMapping(value = "/registreren", method = RequestMethod.GET)
	public String registreren(Model model) {
		Student currentStudent = new Student();
		model.addAttribute("currentStudent", currentStudent);
		return "registreren";
	}
	
	@RequestMapping(value = "/registreren", method = RequestMethod.POST)
	public String postregistreren(@Valid @ModelAttribute("currentStudent") Student currentStudent, Model model) {
//		if(!currentStudent.getPassword().equals(currentStudent.getPasswordConfirmation())){
//			return "registreren";
//		} else {
//		studentMailSender.sendWelcomeEmail(currentStudent.getFirstName(), currentStudent.getEmailAddress());

		if(currentStudent.getPassword().equals(currentStudent.getPasswordConfirmation())){
//			studentMailSender.sendWelcomeEmail(currentStudent.getFirstName(), currentStudent.getEmailAddress());
			studentRepo.save(currentStudent);
			model.addAttribute("firstName", currentStudent.getFirstName());
			model.addAttribute("message", "Gefeliciteerd, je hebt nu een profiel bij Get There! Je bent automatisch ingelogd op je persoonlijke account. Wij verzoeken je vriendelijk de gegevens over je opleiding in te vullen en aan te geven waar je interesses liggen. Daarnaast kun je ook je CV uploaden, maar voel je niet verplicht!");
			return "redirect:/profiel";
		}
		return "registreren";
	}
	
	@RequestMapping(value = "/personal", method = RequestMethod.POST)
	public String updateNaw(Model model) {
		System.out.println("personal records updated");
		return "profile";
	}

}