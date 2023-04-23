package sametyilmaz.ecommerce.business.dto.responses.update;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdatePaymentResponse {
    private int id;
    private String customerName;
    private String cardNumber;
    private String cardCvv;
    private double cardBalance;
}
