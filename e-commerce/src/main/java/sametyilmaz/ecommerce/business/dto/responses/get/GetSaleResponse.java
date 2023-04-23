package sametyilmaz.ecommerce.business.dto.responses.get;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetSaleResponse {
    private int id;
    private double totalPrice;
    private String paymentCustomerName;
    private String paymentCardNumber;
    private String paymentCardExpirationYear;
    private String paymentCardExpirationMonth;
    private String paymentCardCvv;
    private int saleQuantity;
}
