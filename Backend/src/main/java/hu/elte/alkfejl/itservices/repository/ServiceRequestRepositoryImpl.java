package hu.elte.alkfejl.itservices.repository;

import hu.elte.alkfejl.itservices.model.Service;
import hu.elte.alkfejl.itservices.model.ServiceRequest;
import hu.elte.alkfejl.itservices.model.User;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

/**
 *
 * @author gyuri
 */
public class ServiceRequestRepositoryImpl implements ServiceRequestRepositoryCustom{  
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public ServiceRequest findById(int id) {
        try{
        TypedQuery<ServiceRequest> requestQuery = entityManager.createQuery("SELECT rq FROM ServiceRequest rq WHERE rq.id = :id", ServiceRequest.class).setParameter("id", id);
            ServiceRequest req = requestQuery.getSingleResult();
            return req;
        }catch(NoResultException e){
            return null;
        }
    }

    @Override
    public List<ServiceRequest> findByServiceId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public void addServiceRequest(Map<String, String> formData, User requester, Service service) {
        StringBuilder sb = new StringBuilder("{");
        
        for(Map.Entry<String,String> entry:formData.entrySet()){
            sb.append("\""+entry.getKey()+"\":\""+entry.getValue()+"\",");
        }
        sb.setCharAt(sb.length()-1,'}');
        
        ServiceRequest sv = new ServiceRequest();
        sv.setJson_data(sb.toString());
                
        sv.setRequester(requester);
        sv.setAssignedOperator(null);
        sv.setComments(null);
        sv.setDateOfRequest(new Date());
        sv.setState(hu.elte.alkfejl.itservices.model.ServiceRequest.State.OPENED);
        sv.setRequestedService(service);
        sv.setVersion(0);
        
        this.entityManager.persist(sv);
        this.entityManager.flush();
    }
    
    @Override
    public List<ServiceRequest> findByUser(User user){
        try{
            TypedQuery<ServiceRequest> requestQuery = entityManager.createQuery("SELECT rq FROM ServiceRequest rq WHERE rq.requester = :user", ServiceRequest.class).setParameter("user", user);
            return requestQuery.getResultList();
        }catch(NoResultException e){
            return null;
        }
    }
    @Override
    public List<Map<Object,Object>> getRequestsMetadataForUser(User user){
        try{
            List<Map<Object,Object>> result = new LinkedList<>();
            TypedQuery<Object[]> metadataQuery = entityManager.createQuery("SELECT rq.id,rq.state,rq.dateOfRequest,rql.surname,rql.forename,rq.requestedService.name FROM ServiceRequest rq LEFT OUTER JOIN rq.assignedOperator rql WHERE rq.requester = :user", Object[].class).setParameter("user", user);
            List<Object[]> queryResultList = metadataQuery.getResultList();
            for(Object[] obj:queryResultList){
                Map<Object,Object> tmp = new HashMap<>();
                tmp.put("id", obj[0]);
                tmp.put("state",obj[1]);
                
                //tmp.put("requester", obj[1]);
                //tmp.put("assignedOperator",obj[2]);
                //tmp.put("state",obj[3]);
                tmp.put("dateOfRequest",obj[2]);
                tmp.put("assignedOperator",obj[3]==null?"None":obj[3]+" "+obj[4]);
                tmp.put("requestedService",obj[5]);
                result.add(tmp);
            }
            return result;
        }catch(NoResultException e){
            return null;
        }catch(Exception e){
            System.out.println("Something awful has happened in ServiceRequestRepository "+e);
            return null;
        }
    }
}
