package sametyilmaz.ecommerce.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateSalePaymentRequest {
    private String cardNumber;
    private int cardCvv;
    private int cardExpirationYear;
    private int cardExpirationMonth;
    private double balance;
}
