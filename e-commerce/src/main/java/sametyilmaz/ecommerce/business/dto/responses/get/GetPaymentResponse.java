package sametyilmaz.ecommerce.business.dto.responses.get;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetPaymentResponse {
    private int id;
    private String customerName;
    private String cardNumber;
    private String cardCvv;
    private double cardBalance;
}
