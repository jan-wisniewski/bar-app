package wisniewski.jan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import wisniewski.jan.enums.OrderStatus;
import wisniewski.jan.models.Order;

public interface OrderRepository extends JpaRepository<Order,Long> {

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("Update Order o set o.status=:status where o.id = :id")
    void setNewStatus(@Param("id") Long id, @Param("status") OrderStatus status);
}
