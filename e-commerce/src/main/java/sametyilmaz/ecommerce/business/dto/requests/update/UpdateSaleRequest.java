package sametyilmaz.ecommerce.business.dto.requests.update;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateSaleRequest {
    private double totalPrice;
    private int saleQuantity;
    private String paymentCardNumber;
    private int paymentCardExpirationYear;
    private int paymentCardExpirationMonth;
    private int paymentCardCvv;
    private String paymentCustomerName;
}
