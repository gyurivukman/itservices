package hu.elte.alkfejl.itservices.model;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "service_requests")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ServiceRequest extends BaseEntity{
    
    @ManyToOne(targetEntity = User.class)
    private User requester;
    
    @ManyToOne(targetEntity = User.class)
    private User assignedOperator;
    
    @Column(nullable = false)
    private String json_data;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private State state;
    
    @OneToMany(targetEntity=Comment.class)
    @ElementCollection(targetClass=Comment.class)
    private List<Comment> comments;
    
    @Column(nullable = false)
    private Date dateOfRequest;
    
    private enum State{
        OPENED,IN_PROGRESS,CLOSED,REOPENED,BLOCKED
    }
    
    private enum RequestType{
        ACCESS_REQUEST,HELP_REQUEST,BUG_REPORT
    }
    
    
}
