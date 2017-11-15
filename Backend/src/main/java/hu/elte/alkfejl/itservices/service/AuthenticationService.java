package hu.elte.alkfejl.itservices.service;

import hu.elte.alkfejl.itservices.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

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
    
}
