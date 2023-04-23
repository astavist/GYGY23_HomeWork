package sametyilmaz.ecommerce.business.rules;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sametyilmaz.ecommerce.repository.PaymentRepository;

@Service
@AllArgsConstructor
public class PaymentBusinessRules {
    private final PaymentRepository repository;

    public void checkCreditCardNumberForExists() {

    }
}
