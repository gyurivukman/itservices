package hu.elte.alkfejl.itservices.repository;

import hu.elte.alkfejl.itservices.model.Service;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author gyuri
 */

public class ServiceRepositoryImpl implements ServiceRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public void addService(Map<String, String> serviceData) {
        //later.
    }

    @Override
    public Service findById(int id) {
        try{
            TypedQuery<Service> serviceQuery = entityManager.createQuery("SELECT s FROM Service s WHERE s.id = :id", Service.class).setParameter("id", id);
            Service service = serviceQuery.getSingleResult();
            return service;
        }catch(NoResultException e){
            return null;
        }
    }
    
    @Override
    public List<Service> getAllServices(){
        try{
            TypedQuery<Service> serviceQuery = entityManager.createQuery("SELECT s FROM Service s", Service.class);
            return serviceQuery.getResultList();   
        }catch(NoResultException e){
            return null;
        }
    }
    
    @Override
    public List<Map<Object,Object>> getAllServiceNames(){
        try{
            List<Map<Object,Object>> result = new LinkedList<>();
            TypedQuery<Object[]> serviceQuery = entityManager.createQuery("SELECT s.id, s.name FROM Service s", Object[].class);
            List<Object[]> queryResultList = serviceQuery.getResultList();
            
            for(Object[] obj:queryResultList){
                Map<Object,Object> tmp = new HashMap<>();
                tmp.put("id", obj[0]);
                tmp.put("name", obj[1]);
                result.add(tmp);
            }
            return result;
        }catch(NoResultException e){
            return null;
        }
    }
}
