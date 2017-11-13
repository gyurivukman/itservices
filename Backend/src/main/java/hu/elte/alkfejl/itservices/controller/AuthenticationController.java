package hu.elte.alkfejl.itservices.controller;

import hu.elte.alkfejl.itservices.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author simon
 */
@Controller
@RequestMapping("/auth")
public class AuthenticationController {

    @PostMapping("/register")
    @ResponseBody
    public void register(@RequestBody User user) {
        System.out.println("Register POST küldi: " + user.toString());
    }
    
    @PostMapping("/login")
    @ResponseBody
    public void login(@RequestParam String username, @RequestParam String password) {
        System.out.println("Login POST küldi: " + username + " " + password);
    }
       
}
