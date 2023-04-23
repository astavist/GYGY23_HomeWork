package sametyilmaz.ecommerce.business.dto.requests.create;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
    @Enumerated(EnumType.STRING)
    private ProductEnums Status;
}
