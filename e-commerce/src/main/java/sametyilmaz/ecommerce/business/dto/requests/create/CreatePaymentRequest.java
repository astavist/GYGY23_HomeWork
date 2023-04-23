package sametyilmaz.ecommerce.business.dto.requests.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreatePaymentRequest {
    private String customerName;
    private String cardNumber;
    private String cardCvv;
    private double cardBalance;
}
