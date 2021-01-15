package wisniewski.jan.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
@Data
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private BigDecimal price;

    @ManyToMany(mappedBy = "product")
    private Set<Order> orders;

}
