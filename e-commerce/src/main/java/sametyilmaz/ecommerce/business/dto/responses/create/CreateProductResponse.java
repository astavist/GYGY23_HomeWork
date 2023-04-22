package sametyilmaz.ecommerce.business.dto.responses.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sametyilmaz.ecommerce.entities.enums.ProductEnums;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductResponse {
    private int id;
    private String name;
    private int quantity;
    private double price;
    private String description;
    private ProductEnums Status;
}
