package hu.elte.alkfejl.itservices.repository;

import hu.elte.alkfejl.itservices.model.Service;
import hu.elte.alkfejl.itservices.model.ServiceRequest;
import hu.elte.alkfejl.itservices.model.User;
import java.util.List;
import java.util.Map;

/**
 *
 * @author gyuri
 */
public interface ServiceRequestRepositoryCustom {
    public ServiceRequest findById(int id);
    public List<ServiceRequest> findByServiceId(int id);
    public List<ServiceRequest> findByUser(User user);
    public List<Map<Object,Object>> getRequestsMetadataForUser(User user);
    public void addServiceRequest(Map<String,String> formData,User requester,Service service);
}
