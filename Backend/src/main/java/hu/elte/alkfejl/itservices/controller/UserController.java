/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.alkfejl.itservices.controller;

import hu.elte.alkfejl.itservices.model.User;
import hu.elte.alkfejl.itservices.service.AuthenticationService;
import hu.elte.alkfejl.itservices.service.ModifyCredentialsService;
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
 * @author Tomi
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private AuthenticationService authService;
    
    @Autowired
    private ModifyCredentialsService modifyService;
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/modify")
    @ResponseBody
    public ResponseEntity modify(@RequestBody Map<String,String> requestParams) {
        ResponseEntity res;
        HashMap<String,String> errors = new HashMap();
        System.out.println("modify request: " + requestParams);
        boolean isTokenValid = this.authService.validateJwtToken(requestParams.get("token"));
        
        if(isTokenValid) {
            User user = this.authService.getUserFromJwt(requestParams.get("token"));
            errors = modifyService.attemptUserModification(user, requestParams);
            System.out.println("modify errors: " + errors);
            if(errors.isEmpty()){
                res = ResponseEntity.status(HttpStatus.OK).build();
            } else {
                res = ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(errors);
            }
            return res;
        }
        
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(errors);
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/getuser")
    @ResponseBody
    public ResponseEntity getUser(@RequestBody String jwtToken) {
        HashMap<String,String> body = new HashMap();
        
        boolean isTokenValid = this.authService.validateJwtToken(jwtToken);
        
        if(isTokenValid) {
            User user = this.authService.getUserFromJwt(jwtToken);
            body.put("username", user.getUsername());
            body.put("forename", user.getForename());
            body.put("surname", user.getSurname());
        }
        
        return ResponseEntity.status(isTokenValid?HttpStatus.OK:HttpStatus.FORBIDDEN).body(body);
    }
}
