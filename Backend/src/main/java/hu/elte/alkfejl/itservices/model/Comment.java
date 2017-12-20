package hu.elte.alkfejl.itservices.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "comments")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Comment extends BaseEntity{
    
    @Column(nullable = false, unique = true)
    private String text;
    
    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name="user_id",referencedColumnName="id")
    private User createdBy;
    
    @Column(nullable = false, unique = true)
    private Date createdAt;
    
    @Column(nullable = false, unique = true)
    private Date editedAt;
    
    @ManyToOne(targetEntity=ServiceRequest.class)
    @JoinColumn(name="service_request_id",referencedColumnName="id")
    @JsonIgnore
    private ServiceRequest serviceRequest;
}
