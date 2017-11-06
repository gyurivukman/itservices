package hu.elte.alkfejl.itservices.model;

import java.util.List;
import lombok.Data;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import hu.elte.alkfejl.itservices.model.Permission;

/**
 *
 * @author gyuri
 */

@Entity
@Table(name = "roles")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Role extends BaseEntity{
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private RoleName name;
    
    @ManyToMany(targetEntity=Permission.class)
    @ElementCollection(targetClass=Permission.class)
    @Enumerated(EnumType.STRING)
    private List<Permission> permissions;
    
}

enum RoleName {
        GUEST, EMPLOYEE, OPERATOR, OPERATOR_MANAGER, ADMIN
    }
