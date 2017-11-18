package hu.elte.alkfejl.itservices.repository;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author simon
 */
public interface UserRepositoryCustom {
    public HashMap<String, String> addUser(Map<String,String> userData);
}
