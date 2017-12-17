
package hu.elte.alkfejl.itservices.service;

import hu.elte.alkfejl.itservices.model.User;
import hu.elte.alkfejl.itservices.repository.ServiceRequestRepository;
import java.util.HashMap;
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
    
    public Map<String,String> attemptNewServiceRequest(Map<String,String> formdata, User requester){
        Map<String,String> errors = new HashMap<>();
        //valami validáció.
        this.requestRepo.addServiceRequest(formdata,requester);
        return errors;
    }
}
