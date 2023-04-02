package sametyilmaz.rentacar.business.abstracts;

import sametyilmaz.rentacar.business.dto.requests.create.CreateMaintenanceRequest;
import sametyilmaz.rentacar.business.dto.requests.create.CreateReturnMaintenanceRequest;
import sametyilmaz.rentacar.business.dto.requests.update.UpdateMaintenanceRequest;
import sametyilmaz.rentacar.business.dto.responses.create.CreateMaintenanceResponse;
import sametyilmaz.rentacar.business.dto.responses.create.CreateReturnMaintenanceResponse;
import sametyilmaz.rentacar.business.dto.responses.get.GetAllMaintenanceResponse;
import sametyilmaz.rentacar.business.dto.responses.get.GetMaintenanceResponse;
import sametyilmaz.rentacar.business.dto.responses.update.UpdateMaintenanceResponse;

import java.util.List;

public interface MaintenanceService {
    List<GetAllMaintenanceResponse> getAll();
    GetMaintenanceResponse getById(int id);
    CreateMaintenanceResponse add(CreateMaintenanceRequest request);
    UpdateMaintenanceResponse update(int id, UpdateMaintenanceRequest request);
    CreateReturnMaintenanceResponse returnMaintenance(int id, CreateReturnMaintenanceRequest request);
    void delete(int id);
}
