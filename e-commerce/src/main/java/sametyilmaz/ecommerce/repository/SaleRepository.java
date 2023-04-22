package sametyilmaz.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sametyilmaz.ecommerce.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale,Integer> {
}
