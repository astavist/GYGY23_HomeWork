package sametyilmaz.ecommerce.business.dto.responses.get;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetlAllSalesResponse {
    private int id;
    private double totalPrice;
    private String customerName;
    private int saleQuantity;
}
