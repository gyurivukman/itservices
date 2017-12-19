/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.alkfejl.itservices.service;

import hu.elte.alkfejl.itservices.model.User;
import hu.elte.alkfejl.itservices.repository.UserRepository;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author simon
 */
@Service
public class ModifyCredentialsService {
    @Autowired
    private UserRepository userRepository;
    
    public HashMap<String,String> attemptUserModification(User oldUser, Map<String,String> userData){
        HashMap<String,String> errors = validateUserDataFormat(userData);
        if(errors.isEmpty()) {
            if(!oldUser.getUsername().equals(userData.get("username"))) {
                if(!checkUsernameExists(userData.get("username"))) {
                    userRepository.modifyUsername(oldUser, userData.get("username"));
                } else {
                    errors.put("username", "Username already exists!");
                }
            }
            if(!oldUser.getPassword().equals(userData.get("password")) && !userData.get("password").equals("")) {
                userRepository.modifyPassword(oldUser, userData.get("password"));
            }
            if(!oldUser.getForename().equals(userData.get("forename"))) {
                userRepository.modifyForename(oldUser, userData.get("forename"));
            }
            if(!oldUser.getSurname().equals(userData.get("surname"))) {
                userRepository.modifySurname(oldUser, userData.get("surname"));
            }
        }
        
        return errors;
    }
    
    private boolean checkUsernameExists(String username) {
        return this.userRepository.findByUsername(username)!=null;
    }
    
    private HashMap<String,String> validateUserDataFormat(Map<String,String> userData){
        HashMap<String,String> errors = new HashMap<>();
        
        if(!UserCredentialFormatValidator.validateUserNameFormat(userData.get("username"))) errors.put("username", "Invalid username format!");
        //Username must be 5-20 characters long, and can only contain lower and uppercase letters
        
        if(!userData.get("password").equals("") && !UserCredentialFormatValidator.validatePasswordFormat(userData.get("password"))) errors.put("password", "Invalid password format!");
        //Password must be 8-20 characters long, have 1 uppercase letter, 1 lowercase letter and 1 number
        
        return errors;
    }
    
    
}