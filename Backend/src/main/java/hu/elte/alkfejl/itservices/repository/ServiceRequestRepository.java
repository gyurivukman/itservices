package hu.elte.alkfejl.itservices.repository;

import hu.elte.alkfejl.itservices.model.Service;
import hu.elte.alkfejl.itservices.model.ServiceRequest;
import hu.elte.alkfejl.itservices.model.User;
import java.util.List;
import java.util.Map;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author gyuri
 */
public interface ServiceRequestRepository extends CrudRepository<ServiceRequest,Integer> {
    public ServiceRequest findById(int id);
    public List<ServiceRequest> findByServiceId(int id);
    public List<ServiceRequest> findByUser(User user);
    
    public List<Map<Object,Object>> getRequestsMetadataForUser(User user);
    
    public int addServiceRequest(Map<String,String> formData,User requester,Service service);
}
