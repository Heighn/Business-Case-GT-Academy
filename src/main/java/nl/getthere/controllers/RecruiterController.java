package nl.getthere.controllers;

import nl.getthere.model.Correspondence;
import nl.getthere.model.CorrespondenceRepository;
import nl.getthere.model.Event;
import nl.getthere.model.EventRepository;
import nl.getthere.services.StudentMailSender;
import nl.getthere.users.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
	private EventRepository eventRepo;
	@Autowired
	private CorrespondenceRepository correspondenceRepo;
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

	@RequestMapping("/nieuw-bericht")
	public String sendEmailByRecruiter(HttpServletResponse resp){
		return "nieuw-bericht";
	}

	@RequestMapping(value="/nieuw-bericht", method=RequestMethod.POST)
	public String sendEmailByRecruiterPost(String messageText, String subject, String emailAddresses) {
		studentMailSender.sendEmail(messageText, subject, emailAddresses.split(","));
		return "dashboard";
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

	@RequestMapping("/dashboard")
	public String recruitersIngelogd(Model model){
		model.addAttribute("recruiters", recruiterRepo.findAll());
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		model.addAttribute("recruiterName", auth.getName());
		return "dashboard";
	}
	
	@RequestMapping("/beheer")
	public String recruitersBeheer(Model model){
		model.addAttribute("recruiters", recruiterRepo.findAll());
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		model.addAttribute("recruiterName", auth.getName());
		return "beheer";
	}
	
	@RequestMapping("/themas")
	public String recruitersThemas(Model model){
		model.addAttribute("recruiters", recruiterRepo.findAll());
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		model.addAttribute("recruiterName", auth.getName());
		return "themas";
	}
	
	@RequestMapping("/evenementen")
	public String recruitersEvenementen(Model model){
		model.addAttribute("recruiters", recruiterRepo.findAll());
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		model.addAttribute("recruiterName", auth.getName());
		return "evenementen";
	}

	@RequestMapping("/createEvent")
	public String createEvent(Model model){
		Event eventForm = new Event();
		model.addAttribute("eventForm", eventForm);
		return "eventForm";
	}

	@RequestMapping(value="/createEvent", method=RequestMethod.POST)
	public String createEventPost(@ModelAttribute("eventForm") Event eventForm){
		eventRepo.save(eventForm);
		return "redirect:/recruiter/ingelogd";
	}

	@RequestMapping("/studenten")
	public String mailStudenten(Model model){
		model.addAttribute("Hoi", "Hoi Hein!");
		return "studenten";
	}

	@RequestMapping("/correspondentie")
	public String correspondence(){
		return "correspondence";
	}

	@RequestMapping("/nieuwe-correspondentie")
	public String newCorrespondence(Model model){
		Correspondence correspondenceForm = new Correspondence();
		model.addAttribute("correspondenceForm", correspondenceForm);
		return "correspondenceForm";
	}

	@RequestMapping(value="/nieuwe-correspondentie", method=RequestMethod.POST)
	public String newCorrespondencePost(@ModelAttribute("correspondenceForm") Correspondence correspondenceForm){
		correspondenceForm.yearMonthDay();
		correspondenceRepo.save(correspondenceForm);
		return "correspondence";
	}

	@ModelAttribute("recruiter")
	public Recruiter newRecruiter() {
	        return new Recruiter();
	}
}