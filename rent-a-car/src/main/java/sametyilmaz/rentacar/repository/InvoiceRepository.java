package sametyilmaz.rentacar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sametyilmaz.rentacar.entities.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice,Integer> {
}
