package hu.elte.alkfejl.itservices.controller;

import hu.elte.alkfejl.itservices.service.AuthenticationService;
import hu.elte.alkfejl.itservices.service.RegistrationService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author simon/gyuri
 */

@Controller
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationService authService;
    
    @Autowired
    private RegistrationService regService;
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/register")
    @ResponseBody
    public ResponseEntity register(@RequestBody Map<String,String> userData) {
        ResponseEntity res;
        HashMap<String,String> errors = regService.attemptUserRegistration(userData);
        
        if(errors.isEmpty()){
            res = ResponseEntity.status(HttpStatus.OK).build();
        }else{
            res = ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(errors);
        }
        
        return res;
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity login(@RequestBody Map<String, String> requestParams) {
        String username = requestParams.get("username");
        String password = requestParams.get("password");
        HashMap<String,String> body = new HashMap();
        
        boolean isUserValid = this.authService.validateUserCredentials(username, password);
        
        if(isUserValid) body.put("message", this.authService.generateJWT(username));
        
        return ResponseEntity.status(isUserValid?HttpStatus.OK:HttpStatus.FORBIDDEN).body(body);
    }
}
