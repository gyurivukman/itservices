
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
    
    public Map<String,Map<String,String>> attemptNewServiceRequest(Map<String,String> formdata, User requester,
                                                       hu.elte.alkfejl.itservices.model.Service service){
        Map<String,Map<String,String>> ormResponse = new HashMap<>();
        ormResponse.put("errors", new HashMap<String,String>());
        //valami validáció.
        Map<String,String> newRequestIDMap = new HashMap<>();
        newRequestIDMap.put("id", Integer.toString(this.requestRepo.addServiceRequest(formdata,requester,service)));
        ormResponse.put("newRequestIDdata", newRequestIDMap);
        
        return ormResponse;
        
    }
    
    public List<Map<Object,Object>> getRequestsMetadataForUser(User user){
        return this.requestRepo.getRequestsMetadataForUser(user);
    }
    
}
