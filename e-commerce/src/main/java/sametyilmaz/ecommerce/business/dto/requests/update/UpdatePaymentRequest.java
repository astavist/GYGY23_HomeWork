package sametyilmaz.ecommerce.business.dto.requests.update;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdatePaymentRequest {
    private String customerName;
    private String cardNumber;
    private String cardCvv;
    private double cardBalance;
}
