package hu.elte.alkfejl.itservices.controller;

import hu.elte.alkfejl.itservices.model.User;
import hu.elte.alkfejl.itservices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author gyuri
 */

@Controller
@RequestMapping("/user")
public class UserController {
    /*
    @Autowired
    private UserService userService;
*/
    @GetMapping("/greet")
    public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model appmodel) {
        System.out.println("SAJTOS TÉSZTA: "+name);
        //appmodel.addAttribute("name", name);
        return "greeting";
    }

    @GetMapping("/login")
    public String login(Model appmodel) {
        appmodel.addAttribute(new User());
        return "login";
    }

    /*
    @PostMapping("/login")
    public String login(@ModelAttribute User user, Model appmodel) {
        if (userService.isValid(user)) {
            return redirectToGreeting(user);
        }
        appmodel.addAttribute("loginFailed", true);
        return "login";
    }

    @GetMapping("/register")
    public String register(Model appmodel) {
        appmodel.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute User user) {
        user.setRole(USER);
        userService.register(user);

        return redirectToGreeting(user);
    }

    private String redirectToGreeting(@ModelAttribute User user) {
        return "redirect:/user/greet?name=" + user.getUsername();
    }
*/
}
