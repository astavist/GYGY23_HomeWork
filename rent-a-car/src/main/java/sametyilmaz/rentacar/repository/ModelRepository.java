package sametyilmaz.rentacar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sametyilmaz.rentacar.entities.Model;

public interface ModelRepository extends JpaRepository<Model,Integer> {
}
