package sametyilmaz.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sametyilmaz.ecommerce.entities.Payment;

public interface PaymentRepository extends JpaRepository<Payment,Integer> {
    Payment findByCardNumber(String cardNumber);
    boolean existsByCardNumberAndCardCvvAndCardExpirationMonthAndCardExpirationYear(String cardNumber,int cardCvv,int cardExpirationYear,int cardExpirationMonth);

}
