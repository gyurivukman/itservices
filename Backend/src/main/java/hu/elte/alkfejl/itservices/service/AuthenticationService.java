package hu.elte.alkfejl.itservices.service;

import hu.elte.alkfejl.itservices.model.ServiceRequest;
import hu.elte.alkfejl.itservices.model.User;
import hu.elte.alkfejl.itservices.repository.ServiceRequestRepository;
import hu.elte.alkfejl.itservices.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.impl.DefaultClaims;


/**
 *
 * @author gyuri
 */

@Service
public final class AuthenticationService {
    private final static String SECRET = "ThisSecretIsNotSoSecret";
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired 
    private ServiceRequestRepository reqRepository;
    
    public String generateJWT(String username){
        String compactJws = Jwts.builder()
                                .setSubject(username)
                                .signWith(SignatureAlgorithm.HS512, SECRET)
                                //.setExpiration(new Date(now.getTime()+15000))
                                .compact();
        System.out.println("Token: "+compactJws);
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
            return Jwts.parser().setSigningKey(SECRET).isSigned(jwtToken);
        }catch(SignatureException e){
            return false;
        }catch(ExpiredJwtException e){
            System.out.println("Expired JWT!");
            System.out.println(e);
            return false;
        }catch(Exception e){
            System.out.println("Something awfully bad has happened!");
            System.out.println(e);
            return false;
        }
    }
   
    public boolean hasPermission(String username,String permission){
        return this.userRepository.hasPermission(username,permission);
    }
    
    public User getUserFromJwt(String jwtToken){
        String username  = ((DefaultClaims) Jwts.parser().setSigningKey(SECRET).parse(jwtToken).getBody()).getSubject();
        return this.userRepository.findByUsername(username);
    }
    
    public boolean validateJwtForRequestView(String jwtToken,int requestid){
        User user = this.getUserFromJwt(jwtToken);
        ServiceRequest request = this.reqRepository.findOne(requestid);
        return user.getUsername().equals(request.getRequester().getUsername());
    }
}
