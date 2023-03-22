package sametyilmaz.ecommerce.business.abstracts;

import sametyilmaz.ecommerce.entities.concretes.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
    Product getById(int id);
    Product add(Product product);
    Product update(int id,Product product);
    void delete(int id);
}
