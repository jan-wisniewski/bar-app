package wisniewski.jan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import wisniewski.jan.models.Bill;

public interface BillRepository extends JpaRepository<Bill,Long> {
}
