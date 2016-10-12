package nl.getthere.controllers;

import nl.getthere.services.StudentMailSender;
import nl.getthere.users.UserProfile;
import nl.getthere.users.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping("/inloggen")
    public String inloggen(){
        return "inloggen";
    }

    @RequestMapping("/wachtwoordVergeten")
    public String wachtwoordVergeten(){
        return "wachtwoordVergeten";
    }

    @RequestMapping(value="/wachtwoordVergeten", method=RequestMethod.POST)
    public String wachtwoordVergetenPost(String emailAddress, Model model){
        if(userProfileRepo.findByUserName(emailAddress) != null) {
            String newPassword = generateRandomPassword();
            UserProfile userProfile = userProfileRepo.findByUserName(emailAddress);
            userProfile.setPassword(newPassword);
            userProfileRepo.save(userProfile);
            mailSender.sendEmail("Je nieuwe wachtwoord is: " + newPassword, "Nieuw Wachtwoord StudentPortal Get There", emailAddress);
        }else{
            model.addAttribute("errorMessage", "Dit emailadres is bij ons niet bekend. Registreer je om een account aan te maken!");
        }
        return "inloggen";
    }

    public String generateRandomPassword(){
        String randomPassword;
        Random random = new Random();


        char[] word = new char[random.nextInt(8)+3];
        for(int j = 0; j < word.length; j++){
            word[j] = (char)('a' + random.nextInt(26));
        }
        randomPassword = new String(word);

        return randomPassword;
    }
}
