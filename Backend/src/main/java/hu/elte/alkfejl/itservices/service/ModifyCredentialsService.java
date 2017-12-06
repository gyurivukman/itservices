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
    
    public HashMap<String,String> attemptUserModification(Map<String,String> userData){
        HashMap<String,String> errors = validateUserData(userData);
        
        if(errors.isEmpty()) {
            User oldData = userRepository.findByEmployeeId(userData.get("employeeid"));
            if(!oldData.getUsername().equals(userData.get("username"))) {
                userRepository.modifyUsername(oldData, userData.get("username"));
            }
            if(!oldData.getPassword().equals(userData.get("password"))) {
                userRepository.modifyPassword(oldData, userData.get("password"));
            }
            if(!oldData.getForename().equals(userData.get("forename"))) {
                userRepository.modifyForename(oldData, userData.get("forename"));
            }
            if(!oldData.getSurname().equals(userData.get("surname"))) {
                userRepository.modifySurname(oldData, userData.get("surname"));
            }
        }
        
        return errors;
    }
    
    private HashMap<String,String> validateUserData(Map<String,String> userData){
        HashMap<String,String> errors = new HashMap<>();
        
        if(!UserCredentialFormatValidator.validateUserNameFormat(userData.get("username"))) errors.put("username", "Invalid username format!");
        //Username must be 5-20 characters long, and can only contain lower and uppercase letters
        else if(this.userRepository.findByUsername(userData.get("username"))!=null) errors.put("username","Username already exists!");
        
        if(!UserCredentialFormatValidator.validatePasswordFormat(userData.get("password"))) errors.put("password", "Invalid password format!");
        //Password must be 8-20 characters long, have 1 uppercase letter, 1 lowercase letter and 1 number
        
        return errors;
    }
    
    
}