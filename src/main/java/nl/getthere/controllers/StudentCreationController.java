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
import nl.getthere.users.UserProfile;
import nl.getthere.users.UserProfileRepository;

/**
 * Created by hein.dehaan on 11-10-2016.
 */
@Controller
public class StudentCreationController {
    @Autowired
    StudentRepository studentRepo;
    @Autowired
    UserProfileRepository userProfileRepo;

    @RequestMapping(value = "/registreren", method = RequestMethod.GET)
    public String registreren(Model model) {
        Student currentStudent = new Student();
        model.addAttribute("currentStudent", currentStudent);
        return "registreren";
    }

    @RequestMapping(value = "/registreren", method = RequestMethod.POST)
    public String postRegistreren(@Valid @ModelAttribute("currentStudent") Student currentStudent, Model model) {
        if(studentRepo.findByEmailAddress(currentStudent.getEmailAddress()) == null) {

            UserProfile userProfile = new UserProfile();
            userProfile.setUserName(currentStudent.getEmailAddress());
            userProfile.setPassword(currentStudent.getPassword());
            currentStudent.setStatus("Actief");
            userProfile.changeRole("student");
            studentRepo.save(currentStudent);
            userProfileRepo.save(userProfile);


            model.addAttribute("firstName", currentStudent.getFirstName());
            model.addAttribute("message", "Gefeliciteerd, je hebt nu een profiel bij Get There! Je bent automatisch ingelogd op je persoonlijke account. Wij verzoeken je vriendelijk de gegevens over je opleiding in te vullen en aan te geven waar je interesses liggen. Daarnaast kun je ook je CV uploaden, maar voel je niet verplicht!");
            return "redirect:/student/profiel";
        }
        model.addAttribute("errorMessage", "Er bestaat al een account met dit emailaddres!");
        return "registreren";
    }

}
