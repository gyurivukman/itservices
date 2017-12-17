package hu.elte.alkfejl.itservices.controller;

import hu.elte.alkfejl.itservices.model.Service;
import hu.elte.alkfejl.itservices.repository.ServiceRepository;
import hu.elte.alkfejl.itservices.service.AuthenticationService;
import hu.elte.alkfejl.itservices.service.RequestService;
import hu.elte.alkfejl.itservices.service.Service_service;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author gyuri
 */

@Controller
@RequestMapping("/services")
public class ServiceController {
    @Autowired
    private AuthenticationService authService;
    
    @Autowired
    private Service_service serv_service;
    
    @Autowired
    private RequestService reqService;
    
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{id}") 
    public ResponseEntity getServiceDescriptionDataById(@PathVariable int id, @RequestHeader(value="Authorization")String jwtToken){
        ResponseEntity res;
        
        if(this.authService.validateJwtToken(jwtToken)){
            Service service = this.serv_service.findById(id);
            if(service!=null){
                res = ResponseEntity.status(HttpStatus.OK).body(service);
            }else{
                res = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        }
        else{
            res = ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        
        return res;
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{id}/request")
    public ResponseEntity getRequestFormByServiceId(@PathVariable int id,@RequestHeader(value="Authorization")String jwtToken){
        ResponseEntity res;
        if(this.authService.validateJwtToken(jwtToken)){
            Service service = this.serv_service.findById(id);
            if(service!=null){
                Map<String,String> requestData = new HashMap<>();
                requestData.put("formdata", service.getRequestForm());
                res = ResponseEntity.status(HttpStatus.OK).body(requestData);
            }else{
                res = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        }
        else{
            res = ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        
        return res;
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("")
    public ResponseEntity getServiceNames(@RequestHeader("authorization") String jwtToken){
        ResponseEntity res;
        
        if(this.authService.validateJwtToken(jwtToken)) res = ResponseEntity.status(HttpStatus.OK).body(this.serv_service.getAllServiceNames());
        else res = ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        
        return res;
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/{id}")
    public ResponseEntity postRequest(@PathVariable int id,@RequestHeader("authorization") String jwtToken,@RequestBody Map<String,String> formData){
        ResponseEntity res;
        
        if(this.authService.validateJwtToken(jwtToken)){
            Service service = this.serv_service.findById(id);
            if(service!=null){
                Map<String,String> errors = this.reqService.attemptNewServiceRequest(formData,this.authService.getUserFromJwt(jwtToken));
                res = ResponseEntity.status(errors.isEmpty()?HttpStatus.OK:HttpStatus.BAD_REQUEST).body(errors);
            }else{
                res = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        }else{
            res = ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        System.out.println("EZt fogom mondani: "+res);
        return res;
    };
}
