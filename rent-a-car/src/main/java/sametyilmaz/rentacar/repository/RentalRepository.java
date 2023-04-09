package sametyilmaz.rentacar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sametyilmaz.rentacar.entities.Rental;

public interface RentalRepository extends JpaRepository<Rental,Integer> {
}
