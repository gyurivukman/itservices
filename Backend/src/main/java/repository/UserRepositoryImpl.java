package repository;

import hu.elte.alkfejl.itservices.model.User;
import java.util.Optional;
import javax.persistence.EntityManager;

/**
 *
 * @author simon
 */
public class UserRepositoryImpl implements UserRepositoryCustom {

    private EntityManager entityManager;
    

    @Override
    public void addUser(User user) {
        System.out.println("UserRepositoryImpl: " + user.toString());
    }
    
}
