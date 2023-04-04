package sametyilmaz.rentacar.business.abstracts;

import sametyilmaz.rentacar.business.dto.requests.create.CreateMaintenanceRequest;
import sametyilmaz.rentacar.business.dto.requests.update.UpdateMaintenanceRequest;
import sametyilmaz.rentacar.business.dto.requests.update.UpdateMaintenanceStatusForCarRequest;
import sametyilmaz.rentacar.business.dto.responses.create.CreateMaintenanceResponse;
import sametyilmaz.rentacar.business.dto.responses.get.GetAllMaintenancesResponse;
import sametyilmaz.rentacar.business.dto.responses.get.GetMaintenanceResponse;
import sametyilmaz.rentacar.business.dto.responses.update.UpdateMaintenanceResponse;
import sametyilmaz.rentacar.business.dto.responses.update.UpdateMaintenanceStatusForCarResponse;

import java.util.List;

public interface MaintenanceService {
    CreateMaintenanceResponse add(CreateMaintenanceRequest request);
    UpdateMaintenanceResponse update(int id, UpdateMaintenanceRequest request);
    GetMaintenanceResponse getById(int id);
    List<GetAllMaintenancesResponse> getAll();
    UpdateMaintenanceStatusForCarResponse returnFromMaintenance(int id, UpdateMaintenanceStatusForCarRequest request);
    void delete(int id);
}
