package hu.elte.alkfejl.itservices.repository;

import hu.elte.alkfejl.itservices.model.Service;
import java.util.List;
import java.util.Map;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author gyuri
 */

public interface ServiceRepository extends CrudRepository<Service,Integer>,ServiceRepositoryCustom{
    public void addService(Map<String,String> serviceData); //dummy
    
    public Service findById(int id);
    public List<Service> getAllServices();
    public List<Map<Object,Object>> getAllServiceNames();
}
