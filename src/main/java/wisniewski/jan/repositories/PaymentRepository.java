package wisniewski.jan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import wisniewski.jan.models.Payment;

public interface PaymentRepository extends JpaRepository<Payment,Long> {

}
