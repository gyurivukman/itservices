package hu.elte.alkfejl.itservices.model;

import java.sql.Time;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.util.List;
import javax.persistence.OneToMany;

/**
 *
 * @author gyuri
 */

@Entity
@Table(name = "services")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Service extends BaseEntity{
    
    @Column(nullable = false, unique = true)
    private String name;
    
    @Column(nullable = false, length=4000)
    private String description;
    
    @Column(nullable = false)
    private String iconFileName;
    
    @Column(nullable = false)
    private String requiredPosition;
    
    @Column(nullable = false)
    private long averageResponsetime;
    
    @ManyToOne(targetEntity = ServiceType.class)
    private ServiceType serviceType;
    
    @Column(length=4000)
    private String requestForm;
    
    @OneToMany(targetEntity = ServiceRequest.class)
    private List<ServiceRequest> requests;
    
}
