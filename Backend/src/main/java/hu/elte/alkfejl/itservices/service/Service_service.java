package hu.elte.alkfejl.itservices.service;

import hu.elte.alkfejl.itservices.repository.ServiceRepository;
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
public class Service_service {
    @Autowired
    private ServiceRepository serviceRepo;
    
    public hu.elte.alkfejl.itservices.model.Service findById(int id){
        return this.serviceRepo.findById(id);
    }
    
    public List<Map<Object,Object>> getAllServiceNames(){
        return this.serviceRepo.getAllServiceNames();
    }
}
