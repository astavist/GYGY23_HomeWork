package sametyilmaz.ecommerce.business.concretes;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sametyilmaz.ecommerce.business.abstracts.ProductService;
import sametyilmaz.ecommerce.entities.Product;
import sametyilmaz.ecommerce.repository.ProductRepository;


import java.util.List;

@Service
@AllArgsConstructor
public class ProductManager implements ProductService {

    private final ProductRepository repository;

    @Override
    public List<Product> getAll() {
        return repository.findAll();
    }

    @Override
    public Product getById(int id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public Product add(Product product) {
        validateProduct(product);
        return repository.save(product);
    }

    @Override
    public Product update(int id, Product product) {
        validateProduct(product);
        product.setId(id);
        return repository.save(product);
    }

    //    business kuralları
    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    private void validateProduct(Product product) {
        checkIfPriceValid(product);
        checkIfQuantityValid(product);
        checkIfDescriptionValid(product);
    }

    private void checkIfPriceValid(Product product) {
        if (product.getPrice() <= 0) throw new IllegalArgumentException("Price can't be zero or negative");
    }

    private void checkIfQuantityValid(Product product) {
        if (product.getQuantity() <= 0) throw new IllegalArgumentException("Quantity can't be zero or negative");
    }

    private void checkIfDescriptionValid(Product product) {
        if (product.getDescription().length() < 10 || product.getDescription().length() > 50)
            throw new IllegalArgumentException("Description can't be less than 10 or more than 50");
    }
}
