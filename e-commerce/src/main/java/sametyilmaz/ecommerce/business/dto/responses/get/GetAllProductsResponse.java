package sametyilmaz.ecommerce.business.dto.responses.get;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sametyilmaz.ecommerce.entities.enums.ProductEnums;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GetAllProductsResponse {
    private int id;
    private String name;
    private int quantity;
    private double price;
    private String description;
    private ProductEnums Status;
}
