package sametyilmaz.rentacar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sametyilmaz.rentacar.entities.Car;

public interface CarRepository extends JpaRepository<Car,Integer> {
}
