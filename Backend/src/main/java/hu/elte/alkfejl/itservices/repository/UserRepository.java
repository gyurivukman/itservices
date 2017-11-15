package hu.elte.alkfejl.itservices.repository;

import hu.elte.alkfejl.itservices.model.User;
import java.io.Serializable;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author simon
 */
public interface UserRepository extends CrudRepository<User, Integer>, UserRepositoryCustom {
}
