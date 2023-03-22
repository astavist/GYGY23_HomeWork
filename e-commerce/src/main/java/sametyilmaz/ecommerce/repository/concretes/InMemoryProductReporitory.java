package sametyilmaz.ecommerce.repository.concretes;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import sametyilmaz.ecommerce.entities.concretes.Product;
import sametyilmaz.ecommerce.repository.abstracts.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryProductReporitory implements ProductRepository {
    private final List<Product> products;
    public InMemoryProductReporitory() {
        products = new ArrayList<>();
        products.add(new Product(1,"IPhone 13",10,18000,"Apple-Iphone 13"));
        products.add(new Product(2,"Galaxy S21",7,15000,"Samsung-Galaxy S21"));
        products.add(new Product(3,"Monster Laptop",3,23000,"Monster-Abra A5"));
        products.add(new Product(4,"iPad Pro",4,16000,"Apple-iPad Pro"));
    }

    @Override
    public List<Product> getAll() {
        return products;
    }

    @Override
    public Product getById(int id) {
        for (Product product : products) {
            if (product.getId() == id) return product;
        }
        return null;
    }

    @Override
    public Product add(Product product) {
        products.add(product);
        return product;
    }

    @Override
    public Product update(int id, Product product) {
        return products.set(id-1,product);
    }

    @Override
    public void delete(int id) {
        products.remove(id-1);
    }
}
