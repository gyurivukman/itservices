package hu.elte.alkfejl.itservices.service;

import hu.elte.alkfejl.itservices.model.User;
import hu.elte.alkfejl.itservices.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;

/**
 *
 * @author gyuri
 */

@Service
public final class AuthenticationService {
    private final static String SECRET = "ThisSecretIsNotSoSecret";
    
    @Autowired
    private UserRepository userRepository;
    
    public String generateJWT(String username){
        String compactJws = Jwts.builder()
                                .setSubject(username)
                                .signWith(SignatureAlgorithm.HS512, SECRET)
                                .compact();
        
        return compactJws;
    }
    
    public boolean validateUserCredentials(String username,String password){
        User user = this.userRepository.findByUsername(username);
        
        if(user!=null){
            return user.getPassword().equals(password);
        }else{
            return false;
        }
    }
    
    public boolean validateJwtToken(String jwtToken){
        try{
            return Jwts.parser().setSigningKey(SECRET).isSigned(SECRET);
        }catch(SignatureException e){
            return false;
        }catch(Exception e){
            System.out.println("Something awfully bad has happened!");
            return false;
        }
    }
    
    public boolean hasPermission(String username,String permission){
        return this.userRepository.hasPermission(username,permission);
    }
}
