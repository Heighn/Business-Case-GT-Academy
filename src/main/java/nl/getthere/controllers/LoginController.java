package nl.getthere.controllers;

import nl.getthere.services.StudentMailSender;
import nl.getthere.users.RecruiterRepository;
import nl.getthere.users.StudentRepository;
import nl.getthere.users.UserProfile;
import nl.getthere.users.UserProfileRepository;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.util.Random;

/**
 * Created by hein.dehaan on 12-10-2016.
 */
@Controller
public class LoginController {
    @Autowired
    private StudentMailSender mailSender;
    @Autowired
    private UserProfileRepository userProfileRepo;
    @Autowired
    private RecruiterRepository recruiterRepo;
    @Autowired
    private StudentRepository studentRepo;

    @RequestMapping("/login") //Automatic fallback when user has to login
    public String inloggen(){
        return "inloggen";
    }

    @RequestMapping("/inloggen")
    public String inloggenRedirecter(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth.getAuthorities().toString().equals("[student]")) {
            return "redirect:/student/profiel";
        } else if (auth.getAuthorities().toString().equals("[recruiter]")){
            model.addAttribute("recruiterName", auth.getName());
            return "redirect:/recruiter/dashboard";
        }
        return "inloggen";
    }


    @RequestMapping("/wachtwoordVergeten")
    public String wachtwoordVergeten(){
        return "wachtwoordVergeten";
    }

    @RequestMapping(value="/wachtwoordVergeten", method=RequestMethod.POST)
    public String wachtwoordVergetenPost(String emailAddress, Model model) {
        if (userProfileRepo.findByUserName(emailAddress) != null) {
            String newPassword = generateRandomPassword();
            UserProfile userProfile = userProfileRepo.findByUserName(emailAddress);
            userProfile.setPassword(newPassword);
            userProfileRepo.save(userProfile);
            mailSender.sendEmail("Je nieuwe wachtwoord is: " + newPassword, "Nieuw Wachtwoord StudentPortal Get There", emailAddress);
        } else {
            model.addAttribute("errorMessage", "Dit emailadres is bij ons niet bekend. Registreer je om een account aan te maken!");
        }
        return "inloggen";
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/inloggen";
    }

    public String generateRandomPassword(){
        String randomPassword;
        Random random = new Random();

        char[] word = new char[random.nextInt(5)+7];
        for(int j = 0; j < word.length; j++){
            word[j] = (char)('a' + random.nextInt(26));
        }
        randomPassword = new String(word);

        return randomPassword;
    }
}
