package sametyilmaz.ecommerce.business.dto.requests.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateSaleRequest {
    private int productId;
    private String customerName;
    private String paymentCardNumber;
    private String paymentCardExpirationYear;
    private String paymentCardExpirationMonth;
    private String paymentCardCvv;
    private int saleQuantity;
}
