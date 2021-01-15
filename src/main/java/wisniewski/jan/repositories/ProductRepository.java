package wisniewski.jan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import wisniewski.jan.models.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
