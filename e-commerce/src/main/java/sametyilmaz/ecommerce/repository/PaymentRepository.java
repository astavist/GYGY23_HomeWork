package sametyilmaz.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sametyilmaz.ecommerce.entities.Payment;

public interface PaymentRepository extends JpaRepository<Payment,Integer> {
}
