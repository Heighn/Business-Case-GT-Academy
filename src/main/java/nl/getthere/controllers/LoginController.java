package nl.getthere.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by hein.dehaan on 12-10-2016.
 */
@Controller
public class LoginController {
    @RequestMapping("/inloggen")
    public String inloggen(){
        return "inloggen";
    }
}
