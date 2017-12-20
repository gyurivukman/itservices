package hu.elte.alkfejl.itservices.controller;

import hu.elte.alkfejl.itservices.model.Service;
import hu.elte.alkfejl.itservices.model.ServiceRequest;
import hu.elte.alkfejl.itservices.model.User;
import hu.elte.alkfejl.itservices.service.AuthenticationService;
import hu.elte.alkfejl.itservices.service.RequestService;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author vukman
 */
@Controller
@RequestMapping("/requests")
public class RequestController {
    
    @Autowired
    AuthenticationService authService;
    
    @Autowired
    RequestService reqService;
    
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{requestid}")
    @ResponseBody
    public ResponseEntity getRequestDataByID(@PathVariable int requestid,@RequestHeader("authorization") String jwtToken){
        ResponseEntity res;
        if(this.authService.validateJwtToken(jwtToken) && this.authService.validateJwtForRequestView(jwtToken,requestid)){
            ServiceRequest request = this.reqService.getRequestById(requestid);
            
            Map<String,Object> filteredRequestData = new HashMap<>();
            Map<String,Object> filteredServiceData = new HashMap<>();
            
            filteredRequestData.put("id", request.getId());
            filteredRequestData.put("assignedOperator", request.getAssignedOperator()==null?"None":request.getAssignedOperator().getForename()+" "+request.getAssignedOperator().getSurname());
            filteredRequestData.put("comments",request.getComments());
            filteredRequestData.put("dateOfRequest", request.getDateOfRequest());
            filteredRequestData.put("json_data", request.getJson_data());
            filteredRequestData.put("requester", request.getRequester().getForename()+" "+request.getRequester().getSurname());
            filteredRequestData.put("state", request.getState());
            
            Service requestedService = request.getRequestedService();
            filteredServiceData.put("iconFileName",requestedService.getIconFileName());
            filteredServiceData.put("name",requestedService.getName());
            filteredServiceData.put("averageResponseTime",requestedService.getAverageResponsetime());

            
            filteredRequestData.put("requestedService",filteredServiceData);
            
            res = ResponseEntity.status(HttpStatus.OK).body(filteredRequestData);
        }else{
            res = ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return res;
    }
}
