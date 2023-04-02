package sametyilmaz.rentacar.api.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sametyilmaz.rentacar.business.abstracts.MaintenanceService;
import sametyilmaz.rentacar.business.dto.requests.create.CreateMaintenanceRequest;
import sametyilmaz.rentacar.business.dto.requests.create.CreateReturnMaintenanceRequest;
import sametyilmaz.rentacar.business.dto.requests.update.UpdateMaintenanceRequest;
import sametyilmaz.rentacar.business.dto.responses.create.CreateMaintenanceResponse;
import sametyilmaz.rentacar.business.dto.responses.create.CreateReturnMaintenanceResponse;
import sametyilmaz.rentacar.business.dto.responses.get.GetAllMaintenanceResponse;
import sametyilmaz.rentacar.business.dto.responses.get.GetMaintenanceResponse;
import sametyilmaz.rentacar.business.dto.responses.update.UpdateMaintenanceResponse;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/maintenance")
public class MaintenanceController {
    private final MaintenanceService service;
    @GetMapping
    public List<GetAllMaintenanceResponse> getAll() {
        return service.getAll();
    }
    @GetMapping("/{id}")
    public GetMaintenanceResponse getById(@PathVariable int id){
        return service.getById(id);
    }
    @PostMapping
    public CreateMaintenanceResponse add(@RequestBody CreateMaintenanceRequest request) {
        return service.add(request);
    }

    @PutMapping("/{id}")
    public UpdateMaintenanceResponse update(@PathVariable int id,@RequestBody UpdateMaintenanceRequest request) {
        return service.update(id,request);
    }

    @PostMapping("/returnMaintenance/{id}")
    public CreateReturnMaintenanceResponse returnMaintenance(@PathVariable int id ,@RequestBody CreateReturnMaintenanceRequest request) {
        return service.returnMaintenance(id,request);
    }

    @DeleteMapping("/{id}")
    void delete(int id) {
        service.delete(id);
    }
}
