package hu.elte.alkfejl.itservices.service;

import hu.elte.alkfejl.itservices.repository.UserRepository;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gyuri/simon
 */

@Service
public class RegistrationService {
    @Autowired
    private UserRepository userRepository;
    
    public HashMap<String,String> attemptUserRegistration(Map<String,String> userData){
        HashMap<String,String> errors = validateUserData(userData);
        
        if(errors.isEmpty()) {
            userRepository.addUser(userData);
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
        
        if(!UserCredentialFormatValidator.validateEmailFormat(userData.get("email"))) errors.put("email", "Invalid email format!");
        else if(this.userRepository.findByEmail(userData.get("email"))!=null) errors.put("email","Email already in use!");
        
        if(!UserCredentialFormatValidator.validateEmployeeIdFormat(userData.get("employeeid"))) errors.put("employeeid","Invalid employee id!");
        else if(this.userRepository.findByEmployeeId(userData.get("employeeid"))!=null) errors.put("employeeid","Employee ID already in use!");
        
        return errors;
    }
}
