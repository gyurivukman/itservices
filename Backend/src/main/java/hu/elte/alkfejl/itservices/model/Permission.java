package hu.elte.alkfejl.itservices.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

/**
 *
 * @author gyuri
 */
@Entity
@Table(name = "permissions")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Permission extends BaseEntity{
    
    @Column(nullable = false, unique = true)
    private String name;
    
    @ManyToMany
    @JoinTable(name="roles_permissions",
        joinColumns=@JoinColumn(name="role_id"),
        inverseJoinColumns=@JoinColumn(name="permission_id ")
    )
    private List<Role> roles;   
}

/*
    private enum PermissionName{
        REQUEST_SERVICE,
        VIEW_SERVICE,
        APPROVE_REQUEST,
        DECLINE_REQUEST,
        CLOSE_REQUEST,
        REOPEN_REQUEST,
        CHANGE_PRIORITY,
        ASSIGN_REQUEST,
        COMMENT_ON_REQUEST,
        INVOLVE_SOMEONE_ELSE,
        CREATE_SERVICE,
        EDIT_SERVICE,
        ARCHIVE_SERVCE,
        EDIT_PERMISSIONS,
        EDIT_USER_CREDENTIALS
    }
  */  
