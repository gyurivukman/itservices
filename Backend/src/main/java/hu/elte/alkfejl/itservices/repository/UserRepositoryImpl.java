package hu.elte.alkfejl.itservices.repository;

import hu.elte.alkfejl.itservices.model.Permission;
import hu.elte.alkfejl.itservices.model.User;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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

    @Override
    public boolean hasPermission(String username, String permission) {
        List<Permission> permissions = findByUsername(username).getRole().getPermissions();
        boolean hasPermission = false;
        
        int i = 0 ;
        while(i<permissions.size() && !hasPermission){
            hasPermission = permissions.get(i).getName().equals(permission);
            ++i;
        }
        
        return hasPermission;
    }
    
    @Override
    public User findByUsername(String username){
        try{
            TypedQuery<User> usernameQuery = entityManager.createQuery("SELECT u FROM User u WHERE u.username = :name", User.class).setParameter("name", username);
            User user = usernameQuery.getSingleResult();
            return user;
        }catch(NoResultException e){
            return null;
        }
    }
    
    public User findByEmail(String email){ 
        try{
            TypedQuery<User> emailQuery = entityManager.createQuery("SELECT u FROM User u WHERE u.email = :mail", User.class).setParameter("mail", email);
            User user = emailQuery.getSingleResult();        
            return user;
        }catch(NoResultException e){
            return null;
        }
        
    }
    
    public User findByEmployeeId(String employeeId) {
        try{
            TypedQuery<User> employeeIdQuery = entityManager.createQuery("SELECT u FROM User u WHERE u.employeeid = :employeeid", User.class).setParameter("employeeid", employeeId);
            User user = employeeIdQuery.getSingleResult();        
            return user;
        }catch(NoResultException e){
            return null;
        }
    }
    
    @Override
    public User findById(int id){
        try{
            TypedQuery<User> userIdQuery = entityManager.createQuery("SELECT u FROM User u WHERE u.id = :id", User.class).setParameter("id", id);
            User user = userIdQuery.getSingleResult();        
            return user;
        }catch(NoResultException e){
            return null;
        }
    }
    
    public void modifyUsername(User user, String newUsername) {
        try {
            entityManager.createQuery("UPDATE users SET username = \'" + newUsername + "\' WHERE email = :email", User.class)
                .setParameter("email", user.getEmail())
                .executeUpdate();
        } catch(Exception e){
            return;
        } 
    }
    
    public void modifyPassword(User user, String newPassword) {
        try {
            entityManager.createQuery("UPDATE users SET password = \'" + newPassword + "\' WHERE email = :email", User.class)
                .setParameter("email", user.getEmail())
                .executeUpdate(); 
        } catch(Exception e){
            return;
        }
    }
    
    public void modifyForename(User user, String newForename) {
        try {
            entityManager.createQuery("UPDATE users SET forename = \'" + newForename + "\' WHERE email = :email", User.class)
                .setParameter("email", user.getEmail())
                .executeUpdate();
        } catch(Exception e){
            return;
        }     
    }
    
    public void modifySurname(User user, String newSurname) {
        try {
            entityManager.createQuery("UPDATE users SET surname = \'" + newSurname + "\' WHERE email = :email", User.class)
                .setParameter("email", user.getEmail())
                .executeUpdate();
        } catch(Exception e){
            return;
        }     
    }
}
