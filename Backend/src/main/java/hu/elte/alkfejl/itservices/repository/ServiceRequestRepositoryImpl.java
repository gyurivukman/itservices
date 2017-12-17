package hu.elte.alkfejl.itservices.repository;

import hu.elte.alkfejl.itservices.model.ServiceRequest;
import hu.elte.alkfejl.itservices.model.User;
import java.util.Date;
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
    public void addServiceRequest(Map<String, String> formData, User requester) {
        ServiceRequest sv = new ServiceRequest();
        sv.setJson_data(formData.toString());
        sv.setRequester(requester);
        sv.setAssignedOperator(null);
        sv.setComments(null);
        sv.setDateOfRequest(new Date());
        sv.setState(hu.elte.alkfejl.itservices.model.ServiceRequest.State.OPENED);
        sv.setVersion(0);
        
        this.entityManager.persist(sv);
        this.entityManager.flush();
    }
    
    
}
