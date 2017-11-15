package hu.elte.alkfejl.itservices.repository;

import hu.elte.alkfejl.itservices.model.Role;
import hu.elte.alkfejl.itservices.model.User;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 *
 * @author simon
 */
public class UserRepositoryImpl implements UserRepositoryCustom {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    
    @Override
    @Transactional
    public void addUser(Map<String,String> userData) {
        
        User user = new User();
        
        user.setEmail(userData.get("email"));
        user.setEmployeeid(userData.get("employeeid"));
        user.setForename(userData.get("forename"));
        user.setPassword(userData.get("password"));
        user.setSurname(userData.get("surname"));
        user.setUsername(userData.get("username"));
        entityManager.persist(user);
        entityManager.flush();
        
    }
    
}
