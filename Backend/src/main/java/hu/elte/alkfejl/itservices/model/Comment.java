package hu.elte.alkfejl.itservices.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
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
    private User createdBy;
    
    @Column(nullable = false, unique = true)
    private Date createdAt;
    
    @Column(nullable = false, unique = true)
    private Date editedAt;
    
    @ManyToOne(targetEntity=Permission.class)
    private ServiceRequest serviceRequest;
}
