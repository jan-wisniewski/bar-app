package wisniewski.jan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import wisniewski.jan.models.Order;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
