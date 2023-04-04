package sametyilmaz.rentacar.api.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sametyilmaz.rentacar.business.abstracts.MaintenanceService;
import sametyilmaz.rentacar.business.dto.requests.create.CreateMaintenanceRequest;
import sametyilmaz.rentacar.business.dto.requests.update.UpdateMaintenanceRequest;
import sametyilmaz.rentacar.business.dto.requests.update.UpdateMaintenanceStatusForCarRequest;
import sametyilmaz.rentacar.business.dto.responses.create.CreateMaintenanceResponse;
import sametyilmaz.rentacar.business.dto.responses.get.GetAllMaintenancesResponse;
import sametyilmaz.rentacar.business.dto.responses.get.GetMaintenanceResponse;
import sametyilmaz.rentacar.business.dto.responses.update.UpdateMaintenanceResponse;
import sametyilmaz.rentacar.business.dto.responses.update.UpdateMaintenanceStatusForCarResponse;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/maintenance")
public class MaintenanceController {
    private final MaintenanceService maintenanceService;
    @GetMapping
    public List<GetAllMaintenancesResponse> getAllMaintenancesResponses(){
        return maintenanceService.getAll();
    }
    @GetMapping("/{id}")
    public GetMaintenanceResponse getById(@PathVariable int id){
        return maintenanceService.getById(id);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateMaintenanceResponse add(@RequestBody CreateMaintenanceRequest request){
        return maintenanceService.add(request);
    }
    @PutMapping("/{id}")
    public UpdateMaintenanceResponse update(@PathVariable int id, @RequestBody UpdateMaintenanceRequest request){
        return maintenanceService.update(id,request);
    }
    @PutMapping("/status/{id}")
    public UpdateMaintenanceStatusForCarResponse updateStatus(@PathVariable int id, @RequestBody UpdateMaintenanceStatusForCarRequest request){
        return maintenanceService.returnFromMaintenance(id,request);

    }
    @DeleteMapping
    public void delete(@PathVariable int id){
        maintenanceService.delete(id);
    }
}
