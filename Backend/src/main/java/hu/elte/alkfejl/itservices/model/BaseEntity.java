package hu.elte.alkfejl.itservices.model;
import lombok.Data;
import javax.persistence.*;
/**
 *
 * @author gyuri
 */
@Data
@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Version
    private int version;
}
