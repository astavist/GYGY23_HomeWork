package sametyilmaz.ecommerce.business.concretes;

import org.springframework.stereotype.Service;
import sametyilmaz.ecommerce.business.abstracts.ProductService;
import sametyilmaz.ecommerce.entities.concretes.Product;
import sametyilmaz.ecommerce.repository.concretes.InMemoryProductReporitory;


import java.util.List;

@Service
public class ProductManager implements ProductService {

    private final InMemoryProductReporitory repository;

//    dependency injection

    public ProductManager(InMemoryProductReporitory repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> getAll() {
        return repository.getAll();
    }

    @Override
    public Product getById(int id) {
        return repository.getById(id);
    }

    @Override
    public Product add(Product product) {
        return repository.add(product);
    }

    @Override
    public Product update(int id, Product product) {
        validateProduct(product);
        return repository.update(id, product);
    }

    //    business kuralları
    @Override
    public void delete(int id) {
        repository.delete(id);
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
