package nl.getthere.controllers;

import nl.getthere.users.Student;
import nl.getthere.users.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("/student")
public class StudentController {
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
//		model.addAttribute("firstName", currentStudent.getFirstName());
//		model.addAttribute("lastName", currentStudent.getLastName());
//		model.addAttribute("emailAddress", currentStudent.getEmailAddress());
//		model.addAttribute("phoneNumber", currentStudent.getPhoneNumber());
//		model.addAttribute("password", currentStudent.getPassword());
		Student currentStudent = new Student();
		model.addAttribute("currentStudent", currentStudent);
		return "profiel";
	}

	@RequestMapping(value = "/profiel", method = RequestMethod.POST)
	public String postUpdateAccount(@Valid @ModelAttribute("currentStudent") Student currentStudent, Model model) {
		model.addAttribute("firstName", currentStudent.getFirstName());
		return "profiel";
	}

	@RequestMapping(value = "/inloggen", method = RequestMethod.GET)
	public String profiel(Model model) {
		// studentRepo.deleteAll();
		model.addAttribute("shaker", false);
		return "inloggen";
	}

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
//					return "profiel";
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
	
	@RequestMapping(value = "/personal", method = RequestMethod.POST)
	public String updateNaw(Model model) {
		System.out.println("personal records updated");
		return "profile";
	}

}