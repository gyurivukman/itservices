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
@Table(name = "services")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Service extends BaseEntity{
    
    @Column(nullable = false, unique = true)
    private String name;
      
}
