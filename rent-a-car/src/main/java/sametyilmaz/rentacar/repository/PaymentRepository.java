package sametyilmaz.rentacar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sametyilmaz.rentacar.entities.Payment;

public interface PaymentRepository extends JpaRepository<Payment,Integer> {
    Payment findByCardNumber(String cardNumber);
    boolean existsByCardNumber(String cardNumber);

    boolean existsByCardNumberAndCardHolderAndCardExpirationYearAndCardExpirationMonthAndCardCvv(
            String cardNumber, String cardHolder, int cardExpirationYear,int cardExpirationMonth,String cardCvv
    );

//    spring experssion language SPeL
//    @Query("SELECT CASE WHEN COUNT(p) > 0 THEN true ELSE false END" +
//            "FROM Payment p WHERE p.cardNumber = :#{#paymentRequest.cardNumber} " +
//            "AND p.cardHolder = :#{#paymentRequest.cardHolder} " +
//            "AND p.cardExpirationYear = :#{#paymentRequest.cardExpirationYear} " +
//            "AND p.cardExpirationMonth = :#{#paymentRequest.cardExpirationMonth} " +
//            "AND p.cardCvv = :#{#paymentRequest.cardCvv}")
//    boolean existsByCardNumberAndCardHolderAndCardExpirationYearAndCardExpirationMonthAndCardCvv(
//            @Param("paymentRequest")PaymentRequest paymentRequest);

}
