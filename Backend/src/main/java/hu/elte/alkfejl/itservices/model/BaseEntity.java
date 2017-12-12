package hu.elte.alkfejl.itservices.model;
import java.io.Serializable;
import lombok.Data;
import javax.persistence.*;
/**
 *
 * @author gyuri
 */
@Data
@MappedSuperclass
public class BaseEntity implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Version
    private int version;
}
