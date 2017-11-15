package hu.elte.alkfejl.itservices.service;

import hu.elte.alkfejl.itservices.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author gyuri
 */

@Service
public class AuthenticationService {
    @Autowired
    private UserRepository userRepository;
    
    public String generateJWT(String username){
        String compactJws = Jwts.builder()
                                .setSubject(username)
                                .signWith(SignatureAlgorithm.HS512, "Kukken")
                                .compact();
        
        return compactJws;
    }
    
    public HashMap<String,String> attemptUserRegistration(Map<String,String> userData){
        HashMap<String,String> errors = validateUserDataForm(userData);
        if(errors.isEmpty()) userRepository.addUser(userData);
        return errors;
    }
    
    public HashMap<String,String> validateUserDataForm(Map<String,String> userData){
        HashMap<String,String> errors = new HashMap<>();
        
        if(!validateUserNameFormat(userData.get("username"))) errors.put("username", "Username must be 5-13 characters long, have at least 1 uppercase letter, 1 lowercase  letter and 1 number");
        if(!validatePasswordFormat(userData.get("password"))) errors.put("password", "Password must be 5-13 least 8 characters long, have 1 uppercase letter, 1 lowercase letter and 1 number");
        if(!validateEmailFormat(userData.get("email"))) errors.put("email", "Invalid email format!");
        if(!validateEmployeeId(userData.get("employeeid"))) errors.put("employeeid","Invalid employee id!");
        
        return errors;
    }
    
    private boolean validateUserNameFormat(String username){
        return username.matches("^[a-zA-Z0-9]{5,13}$");
    }
    
    private boolean validatePasswordFormat(String password){
        return password.matches("^[a-zA-Z0-9]{5,13}$");
    }
    
    private boolean validateEmailFormat(String email){
        return email.matches("[a-z]+@[a-z]+\\.[a-z]{3}");
    }
    
    private boolean validateEmployeeId(String employeeid){
        return employeeid.matches("[0-9]{8}");
    }
}
