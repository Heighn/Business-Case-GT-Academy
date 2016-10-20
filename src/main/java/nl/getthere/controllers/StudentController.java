package nl.getthere.controllers;

import nl.getthere.formbeans.ContactGegevensBean;
import nl.getthere.formbeans.PersoonsGegevensBean;
import nl.getthere.formbeans.ThemeBean;
import nl.getthere.model.DataChangeRepository;
import nl.getthere.model.Theme;
import nl.getthere.model.ThemeRepository;
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
	@Autowired
	private ThemeRepository themeRepo;
	@Autowired
	private DataChangeRepository dataChangeRepo;

	@RequestMapping("/verwijderen")
	public String deleteAccount() {
		System.out.println("delete Account");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Student loggedInStudent = studentRepo.findByEmailAddress(auth.getName());
		loggedInStudent.setStatus("Verwijderd");
		studentRepo.save(loggedInStudent);
		return "redirect:/logout";
	}

	@RequestMapping(value = "/profiel", method = RequestMethod.GET)
	public String profielGet(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Student loggedInStudent = studentRepo.findByEmailAddress(auth.getName());

		PersoonsGegevensBean persoonsGegevensBean = new PersoonsGegevensBean(loggedInStudent);
		model.addAttribute("persoonsGegevensBean", persoonsGegevensBean);

		ContactGegevensBean contactGegevensBean = new ContactGegevensBean(loggedInStudent);
		model.addAttribute("contactGegevensBean", contactGegevensBean);

		ThemeBean themeBean = new ThemeBean();
		model.addAttribute("themeBean", themeBean);


		model.addAttribute("firstName", loggedInStudent.getFirstName());
		model.addAttribute("lastName", loggedInStudent.getLastName());
		model.addAttribute("emailAdres", loggedInStudent.getEmailAddress());
		try{
			model.addAttribute("gebDatum", loggedInStudent.getGebDatum().toString().replaceAll("-", "/").substring(0, 10));
		}catch(NullPointerException nE){
			//Nothing to do here
		}
		try{
			model.addAttribute("afstudeerDatum", loggedInStudent.getAfstudeerDatum().toString().replaceAll("-", "/").substring(0, 10));
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

		loggedInStudent = persoonsGegevensBean.fillStudent(loggedInStudent, dataChangeRepo);
		studentRepo.save(loggedInStudent);

		return "redirect:/student/profiel";
	}

	@RequestMapping(value = "/contactGegevensUpdate", method=RequestMethod.POST)
	public String contactGegevensPost(@ModelAttribute("contactGegevensBean") ContactGegevensBean contactGegevensBean, Model model){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Student loggedInStudent = studentRepo.findByEmailAddress(auth.getName());
		loggedInStudent = contactGegevensBean.fillStudent(loggedInStudent, dataChangeRepo);
		studentRepo.save(loggedInStudent);
		return "redirect:/student/profiel";
	}

	@RequestMapping(value = "/themasUpdate", method=RequestMethod.POST)
	public String contactGegevensPost(@ModelAttribute("themeBean") ThemeBean themeBean, Model model){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Student loggedInStudent = studentRepo.findByEmailAddress(auth.getName());
		loggedInStudent = themeBean.fillStudent(loggedInStudent);
		studentRepo.save(loggedInStudent);
		return "redirect:/student/profiel";
	}

	@RequestMapping("/evenementen")
	public String evenementen(){
		return "studentEvenementen";
	}

	@RequestMapping("/add")
	public String add(){
		themeRepo.deleteAll();
		Theme theme = new Theme("Domotica en Robotica");
		themeRepo.save(theme);
		theme = new Theme("Big Data");
		themeRepo.save(theme);
		theme = new Theme("Software Development");
		themeRepo.save(theme);
		theme = new Theme("Software Architectuur");
		themeRepo.save(theme);
		theme = new Theme("Software Security");
		themeRepo.save(theme);
		theme = new Theme("Internet of Things");
		themeRepo.save(theme);
		theme = new Theme("Virtual Reality");
		themeRepo.save(theme);
		theme = new Theme("Gamification");
		themeRepo.save(theme);
		theme = new Theme("Business Consultancy");
		themeRepo.save(theme);
		theme = new Theme("Test Engineering");
		themeRepo.save(theme);

		return "redirect:/student/profiel";
	}
}