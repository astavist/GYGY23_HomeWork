package sametyilmaz.rentacar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sametyilmaz.rentacar.entities.Maintenance;

public interface MaintenanceRepository extends JpaRepository<Maintenance,Integer> {
}
