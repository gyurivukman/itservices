package hu.elte.alkfejl.itservices.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author gyuri
 */

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String forename;
    
    @Column(nullable = false)
    private String surname;
    
    @Column(nullable = false)
    private String password;
    
    @Column(nullable = false)
    private String employeeid;
    
    @JsonIgnore
    @OneToMany(targetEntity=Comment.class,mappedBy="createdBy")
    private List<Comment> comments;
    
    @ManyToOne(targetEntity = Role.class)
    @JoinColumn(insertable=false)
    private Role role;
    
}
