package sametyilmaz.rentacar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sametyilmaz.rentacar.entities.Brand;

//CRUD Operations
public interface BrandRepository extends JpaRepository<Brand,Integer> {
    boolean existsByNameIgnoreCase(String name);
}
