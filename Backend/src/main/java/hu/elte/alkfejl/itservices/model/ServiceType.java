package hu.elte.alkfejl.itservices.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 *
 * @author gyuri
 */
@Entity
@Table(name = "service_types")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ServiceType extends BaseEntity{
    
    @Column(nullable=false,unique=true)
    private String serviceType;
    
}
