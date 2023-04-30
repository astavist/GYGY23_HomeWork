package sametyilmaz.ecommerce.business.rules;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sametyilmaz.ecommerce.common.dto.CreateSalePaymentRequest;
import sametyilmaz.ecommerce.repository.PaymentRepository;

@Service
@AllArgsConstructor
public class PaymentBusinessRules {
    private final PaymentRepository repository;

    public void checkIfBalanceIsEnough(double balance, double price) {
        if (balance < price) {
            throw new RuntimeException("Bakiye yetersiz");
        }
    }

    public void checkIfPaymentIsValid(CreateSalePaymentRequest request) {
        if (!repository.existsByCardNumberAndCardCvvAndCardExpirationMonthAndCardExpirationYear(
                request.getCardNumber(),
                request.getCardCvv(),
                request.getCardExpirationMonth(),
                request.getCardExpirationYear()
        )) {
            throw new RuntimeException("Kart bulunamadı");
        }

    }
}
