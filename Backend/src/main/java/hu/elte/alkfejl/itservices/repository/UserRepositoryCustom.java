package hu.elte.alkfejl.itservices.repository;

import hu.elte.alkfejl.itservices.model.User;
import java.util.Map;

/**
 *
 * @author simon
 */
public interface UserRepositoryCustom {
    
    public void addUser(Map<String,String> userData);
    
    public boolean hasPermission(String username, String permission);
    
    public User findByUsername(String username);
    
    public User findByEmail(String email);
    
}
