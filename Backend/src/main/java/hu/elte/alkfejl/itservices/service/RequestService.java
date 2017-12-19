
package hu.elte.alkfejl.itservices.service;

import hu.elte.alkfejl.itservices.model.ServiceRequest;
import hu.elte.alkfejl.itservices.model.User;
import hu.elte.alkfejl.itservices.repository.ServiceRequestRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gyuri
 */
@Service
public class RequestService {
    @Autowired
    private ServiceRequestRepository requestRepo;
    
    public Map<String,String> attemptNewServiceRequest(Map<String,String> formdata, User requester,
                                                       hu.elte.alkfejl.itservices.model.Service service){
        Map<String,String> errors = new HashMap<>();
        //valami validáció.
        this.requestRepo.addServiceRequest(formdata,requester,service);
        return errors;
    }
    
    public List<Map<Object,Object>> getRequestsMetadataForUser(User user){
        return this.requestRepo.getRequestsMetadataForUser(user);
    }
    
    
}
