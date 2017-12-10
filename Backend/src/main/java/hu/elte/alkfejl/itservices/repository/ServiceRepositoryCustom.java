package hu.elte.alkfejl.itservices.repository;

import hu.elte.alkfejl.itservices.model.Pair;
import hu.elte.alkfejl.itservices.model.Service;
import java.util.List;
import java.util.Map;

/**
 *
 * @author gyuri
 */

public interface ServiceRepositoryCustom {
    public void addService(Map<String,String> serviceData); //dummy
    
    public Service findById(int id);
    public List<Service> getAllServices();
    public List<Map<Object,Object>> getAllServiceNames();
}
