package hu.elte.alkfejl.itservices.model;

import java.util.List;
import lombok.Data;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

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
    
    @Column(nullable = false, unique = true)
    private String name;
    
    @ManyToMany
    @JoinTable(name="roles_permissions",
         joinColumns=@JoinColumn(name="permission_id"),
            inverseJoinColumns=@JoinColumn(name="role_id"))
    private List<Permission> permissions;
    
}