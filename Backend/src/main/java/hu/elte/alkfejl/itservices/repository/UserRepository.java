package hu.elte.alkfejl.itservices.repository;

import hu.elte.alkfejl.itservices.model.User;
import java.util.Map;
import javax.validation.ConstraintViolationException;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author simon
 */
public interface UserRepository extends CrudRepository<User, Integer>, UserRepositoryCustom {
    
    public void addUser(Map<String,String> userData);
    
    public boolean hasPermission(String username, String permission);
    
    public User findByUsername(String username);
    
    public User findByEmail(String email);
    
    public User findByEmployeeId(String employeeId);
    
}
