package sametyilmaz.ecommerce.business.dto.responses.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreatePaymentResponse {
    private int id;
    private String customerName;
    private String cardNumber;
    private int cardExpirationYear;
    private int cardExpirationMonth;
    private int cardCvv;
    private double cardBalance;
}
