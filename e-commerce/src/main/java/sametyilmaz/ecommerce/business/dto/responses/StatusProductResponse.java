package sametyilmaz.ecommerce.business.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sametyilmaz.ecommerce.entities.enums.ProductEnums;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StatusProductResponse {
    private int id;
    private String name;
    private int quantity;
    private double price;
    private String description;
    private ProductEnums Status;
}
