package hu.elte.alkfejl.itservices.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import hu.elte.alkfejl.itservices.model.Role;
import javax.persistence.ElementCollection;

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
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private PermissionName name;

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
    
    
    @ManyToMany(targetEntity = Role.class,mappedBy="permissions")
    @ElementCollection(targetClass=Role.class)
    @Enumerated(EnumType.STRING)
    private List<Role> roles;   
}
