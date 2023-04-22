package sametyilmaz.ecommerce.business.dto.responses.update;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateSaleResponse {
    private int id;
    private double totalPrice;
    private String customerName;
    private int saleQuantity;
}
