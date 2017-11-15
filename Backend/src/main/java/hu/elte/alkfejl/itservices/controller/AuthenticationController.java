package hu.elte.alkfejl.itservices.controller;

import hu.elte.alkfejl.itservices.model.User;
import hu.elte.alkfejl.itservices.service.AuthenticationService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author simon
 */

@Controller
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationService authService;
    
    @PostMapping("/register")
    @ResponseBody
    public void register(@RequestBody User user) {
        System.out.println("Register POST küldi: " + user.toString());
    }
    
    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity login(@RequestBody Map<String, String> requestParams) {    
        String username = requestParams.get("username");
        String password = requestParams.get("password");
        System.out.println("Login POST küldi: " + username + " " + password);
        
        return ResponseEntity.status(HttpStatus.OK).body(this.authService.generateJWT(username));
    }
    
    @GetMapping("/sampleloginjson")
    @ResponseBody
    public Map<String, String> testLogin() {
        Map<String, String> requestParams = new HashMap();
        requestParams.put("username", "Sanyi");
        requestParams.put("password", "ayy lmao");
        return requestParams;
    }
       
}
