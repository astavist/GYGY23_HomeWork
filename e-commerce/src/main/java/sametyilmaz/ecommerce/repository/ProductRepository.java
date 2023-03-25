package sametyilmaz.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sametyilmaz.ecommerce.entities.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
