package nl.getthere.controllers;

import nl.getthere.formbeans.ContactGegevensBean;
import nl.getthere.formbeans.PersoonsGegevensBean;
import nl.getthere.users.Student;
import nl.getthere.users.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentRepository studentRepo;

	@RequestMapping("/inactief")
	public String deleteAccount() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Student loggedInStudent = studentRepo.findByEmailAddress(auth.getName());
		loggedInStudent.setInActief(true);

		return "inloggen";
	}

	@RequestMapping(value = "/profiel", method = RequestMethod.GET)
	public String profielGet(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Student loggedInStudent = studentRepo.findByEmailAddress(auth.getName());

		PersoonsGegevensBean persoonsGegevensBean = new PersoonsGegevensBean(loggedInStudent);
		model.addAttribute("persoonsGegevensBean", persoonsGegevensBean);

		ContactGegevensBean contactGegevensBean = new ContactGegevensBean(loggedInStudent);
		model.addAttribute("contactGegevensBean", contactGegevensBean);


		model.addAttribute("firstName", loggedInStudent.getFirstName());
		model.addAttribute("lastName", loggedInStudent.getLastName());
		model.addAttribute("emailAdres", loggedInStudent.getEmailAddress());
		try{
			model.addAttribute("gebDatum", loggedInStudent.getGebDatum().toString().replaceAll("-", "/").substring(0, 10));
		}catch(NullPointerException nE){
			//Nothing to do here
		}
		try{
			model.addAttribute("woonplaats", loggedInStudent.getWoonplaats());
		}catch(NullPointerException nE){
			//Nothing to do here
		}
		try{
			model.addAttribute("phoneNumber", loggedInStudent.getPhoneNumber());
		}catch(NullPointerException nE){
			//Nothing to do here
		}
		try{
			model.addAttribute("linkedIn", loggedInStudent.getLinkedIn());
		}catch(NullPointerException nE){
			//Nothing to do here
		}

		return "profiel";
	}

	@RequestMapping(value = "/persoonsGegevensUpdate", method=RequestMethod.POST)
	public String persoonsGegevensPost(@ModelAttribute("persoonsGegevensBean") PersoonsGegevensBean persoonsGegevensBean, Model model){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Student loggedInStudent = studentRepo.findByEmailAddress(auth.getName());
		loggedInStudent = persoonsGegevensBean.fillStudent(loggedInStudent);
		studentRepo.save(loggedInStudent);

		return "redirect:/student/profiel";
	}

	@RequestMapping(value = "/contactGegevensUpdate", method=RequestMethod.POST)
	public String contactGegevensPost(@ModelAttribute("contactGegevensBean") ContactGegevensBean contactGegevensBean, Model model){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Student loggedInStudent = studentRepo.findByEmailAddress(auth.getName());
		loggedInStudent = contactGegevensBean.fillStudent(loggedInStudent);
		studentRepo.save(loggedInStudent);
		return "redirect:/student/profiel";
	}

	@RequestMapping(value = "/inloggen", method = RequestMethod.GET)
	public String inloggen(Model model) {
		model.addAttribute("shaker", false);
		return "inloggen";
	}
}