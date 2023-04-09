package sametyilmaz.rentacar.business.abstracts;

import sametyilmaz.rentacar.business.dto.requests.create.CreateRentalRequest;
import sametyilmaz.rentacar.business.dto.requests.update.UpdateRentalRequest;
import sametyilmaz.rentacar.business.dto.responses.create.CreateRentalResponse;
import sametyilmaz.rentacar.business.dto.responses.get.rental.GetAllRentalsResponse;
import sametyilmaz.rentacar.business.dto.responses.get.rental.GetRentalResponse;
import sametyilmaz.rentacar.business.dto.responses.update.UpdateRentalResponse;

import java.util.List;

public interface RentalService {
    List<GetAllRentalsResponse> getAll();
    GetRentalResponse getById(int id);
    CreateRentalResponse add(CreateRentalRequest request);
    UpdateRentalResponse update(int id, UpdateRentalRequest request);
    void delete(int id);
}
