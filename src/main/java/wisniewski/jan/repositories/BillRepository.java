package wisniewski.jan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import wisniewski.jan.models.Bill;

import java.util.Optional;

public interface BillRepository extends JpaRepository<Bill,Long> {

    @Query("select b from Bill b where b.order.id = :id")
    Optional<Bill> findByOrderId(@Param("id") Long id);

}
