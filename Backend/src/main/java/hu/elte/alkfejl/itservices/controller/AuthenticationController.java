package hu.elte.alkfejl.itservices.controller;

import hu.elte.alkfejl.itservices.service.AuthenticationService;
import hu.elte.alkfejl.itservices.service.RegistrationService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
    
    @Autowired
    private RegistrationService regService;
    
    @PostMapping("/register")
    @ResponseBody
    public ResponseEntity register(@RequestBody Map<String,String> userData) {
        ResponseEntity res;
        HashMap<String,String> errors = regService.attemptUserRegistration(userData);
        
        if(errors.isEmpty()){
            res = ResponseEntity.status(HttpStatus.OK).build();
        }
        else{
            res = ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(errors);
        }
        
        return res;
    }
    
    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity login(@RequestBody Map<String, String> requestParams) {
        String username = requestParams.get("username");
        String password = requestParams.get("password");
        boolean isUserValid = this.authService.validateUserCredentials(username, password);
        
        return ResponseEntity.status(isUserValid?HttpStatus.OK:HttpStatus.FORBIDDEN)
                                    .body(isUserValid?this.authService.generateJWT(username):"Wrong username or password!");
    }
}
