package sametyilmaz.ecommerce.business.rules;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sametyilmaz.ecommerce.entities.Product;
import sametyilmaz.ecommerce.entities.enums.ProductEnums;
import sametyilmaz.ecommerce.repository.ProductRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductBusinessRules {
    private final ProductRepository repository;

    public void checkIfProductExists(int id) {
        if (!repository.existsById(id)) throw new RuntimeException("Ürün bulunamadı");
    }
    public void checkIfPriceValid(Product product) {
        if (product.getPrice() <= 0) throw new IllegalArgumentException("Price can't be zero or negative");
    }

    public void checkIfQuantityValid(Product product) {
        if (product.getQuantity() < 0) throw new IllegalArgumentException("Quantity can't be negative");
    }

    public void checkIfDescriptionValid(Product product) {
        if (product.getDescription().length() < 10 || product.getDescription().length() > 50)
            throw new IllegalArgumentException("Description can't be less than 10 or more than 50");
    }
}
