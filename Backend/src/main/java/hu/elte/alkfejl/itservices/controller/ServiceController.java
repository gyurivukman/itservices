package hu.elte.alkfejl.itservices.controller;

import hu.elte.alkfejl.itservices.model.Service;
import hu.elte.alkfejl.itservices.repository.ServiceRepository;
import hu.elte.alkfejl.itservices.service.AuthenticationService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    private ServiceRepository serviceRepository;
    
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{id}/description")
    @ResponseBody
    public ResponseEntity getServiceDescriptionById(@PathVariable int id, @RequestHeader(value="Authorization")String jwtToken){
        ResponseEntity res;
        if(this.authService.validateJwtToken(jwtToken)){
            Service service = this.serviceRepository.findById(id);
            if(service!=null){
                HashMap<String,String> jsondata = new HashMap<>();
                jsondata.put("description", service.getDescription());
                res = ResponseEntity.status(HttpStatus.OK).body(jsondata);
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
    @ResponseBody
    public ResponseEntity getRequestFormByServiceId(@PathVariable int id,@RequestHeader(value="Authorization")String jwtToken){
        ResponseEntity res;
        if(this.authService.validateJwtToken(jwtToken)){
            Service service = this.serviceRepository.findById(id);
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
    @GetMapping("")
    @ResponseBody
    public ResponseEntity getServiceNames(@RequestHeader("authorization") String jwtToken){
        ResponseEntity res;
        
        if(this.authService.validateJwtToken(jwtToken)) res = ResponseEntity.status(HttpStatus.OK).body(this.serviceRepository.getAllServiceNames());
        else res = ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        return res;
    }
}
