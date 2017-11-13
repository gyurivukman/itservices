package hu.elte.alkfejl.itservices.controller;

import hu.elte.alkfejl.itservices.model.Role;
import hu.elte.alkfejl.itservices.model.User;
import org.springframework.web.bind.annotation.ResponseBody;
import hu.elte.alkfejl.itservices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import repository.UserRepository;
import repository.UserRepositoryImpl;

/**
 *
 * @author gyuri
 */

@Controller
@RequestMapping("/user")
public class UserController {

    UserRepositoryImpl userRepository;
    
    public UserController() {
        this.userRepository = new UserRepositoryImpl();
    }
    
    
    /*
    @Autowired
    private UserService userService;
    */
    @GetMapping("/greet")
    @ResponseBody
    public String greeting(/*@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model appmodel*/) {
        //appmodel.addAttribute("name", name);
        return "greeting";
    }
    
    @GetMapping("/userjson")
    @ResponseBody
    public User userJson() {
        User ret = new User("username", "email", "pw", new Role());
        return ret;
    }
    
    @PostMapping("/post")
    @ResponseBody
    public void postTest(@RequestBody User user) {
        System.out.println("POST küldi: " + user.toString());
        this.userRepository.addUser(user);
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
