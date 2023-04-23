package sametyilmaz.ecommerce.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import sametyilmaz.ecommerce.entities.Product;
import sametyilmaz.ecommerce.entities.enums.ProductEnums;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
