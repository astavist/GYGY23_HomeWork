package sametyilmaz.ecommerce.business.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sametyilmaz.ecommerce.entities.enums.ProductEnums;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductRequest {
    private String name;
    private int quantity;
    private double price;
    private String description;
    private ProductEnums Status;
}
