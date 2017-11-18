package hu.elte.alkfejl.itservices.repository;

import hu.elte.alkfejl.itservices.model.Role;
import hu.elte.alkfejl.itservices.model.User;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
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
    public HashMap<String, String> addUser(Map<String,String> userData) {
        HashMap<String, String> errors = new HashMap();
        
        User user = new User();
        
        user.setEmail(userData.get("email"));
        user.setEmployeeid(userData.get("employeeid"));
        user.setForename(userData.get("forename"));
        user.setPassword(userData.get("password"));
        user.setSurname(userData.get("surname"));
        user.setUsername(userData.get("username"));
        
        TypedQuery<User> usernameQuery = entityManager.createQuery("SELECT u FROM User u WHERE u.username = :name", User.class).setParameter("name", userData.get("username"));
        List<User> usernameResults = usernameQuery.getResultList();
        if(!usernameResults.isEmpty()) {
            errors.put("username", "This username is taken!");
        }
        
        TypedQuery<User> emailQuery = entityManager.createQuery("SELECT u FROM User u WHERE u.email = :mail", User.class).setParameter("mail", userData.get("email"));
        List<User> emailResults = emailQuery.getResultList();
        if(!emailResults.isEmpty()) {
            errors.put("email", "This email is already registered!");
        }
        
        if(errors.isEmpty()) {
            entityManager.persist(user);
            entityManager.flush();
        }
        
        return errors;
    }
    
}
