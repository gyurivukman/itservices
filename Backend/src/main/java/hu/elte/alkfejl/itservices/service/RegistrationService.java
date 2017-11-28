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
        
        if(!validateUserNameFormat(userData.get("username"))) errors.put("username", "Username must be 5-13 characters long, and can only contain lower and uppercase letters");
        else if(this.userRepository.findByUsername(userData.get("username"))!=null) errors.put("username","Username already exists!");
        
        if(!validatePasswordFormat(userData.get("password"))) errors.put("password", "Password must be 8-13 characters long, have 1 uppercase letter, 1 lowercase letter and 1 number");
        
        if(!validateEmailFormat(userData.get("email"))) errors.put("email", "Invalid email format!");
        else if(this.userRepository.findByEmail(userData.get("email"))!=null) errors.put("email","Email already in use!");
        
        if(!validateEmployeeId(userData.get("employeeid"))) errors.put("employeeid","Invalid employee id!");
        
        return errors;
    }
    
    private boolean validateUserNameFormat(String username){
        return username.matches("^[a-zA-Z]{5,13}$");
    }
    
    private boolean validatePasswordFormat(String password){
        boolean hasUppercase = password.matches(".*[A-Z]+.*");
        boolean hasNumber = password.matches(".*[0-9]+.*");
        boolean correctLength = password.matches("^[a-zA-Z0-9]{5,13}$");
        return hasUppercase && hasNumber && correctLength;
    }
    
    private boolean validateEmailFormat(String email){
        return email.matches("[a-z\\-\\_0-9\\.]+@[a-z\\-]+\\.[a-z]{3}");
    }
    
    private boolean validateEmployeeId(String employeeid){
        return employeeid.matches("[0-9]{8}");
    }
}
