package sametyilmaz.starbucks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sametyilmaz.starbucks.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
