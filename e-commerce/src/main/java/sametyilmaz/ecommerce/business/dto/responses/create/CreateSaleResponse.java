package sametyilmaz.ecommerce.business.dto.responses.create;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sametyilmaz.ecommerce.entities.enums.ProductEnums;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateSaleResponse {
    private int id;
    private double totalPrice;
    private String paymentCustomerName;
    private String paymentCardNumber;
    private String cardExpirationYear;
    private String cardExpirationMonth;
    private String paymentCardCvv;
    private int saleQuantity;
}
