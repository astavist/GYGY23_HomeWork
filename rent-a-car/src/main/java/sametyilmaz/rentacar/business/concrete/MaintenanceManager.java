package sametyilmaz.rentacar.business.concrete;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import sametyilmaz.rentacar.business.abstracts.CarService;
import sametyilmaz.rentacar.business.abstracts.MaintenanceService;
import sametyilmaz.rentacar.business.dto.requests.create.CreateMaintenanceRequest;
import sametyilmaz.rentacar.business.dto.requests.update.UpdateCarRequest;
import sametyilmaz.rentacar.business.dto.requests.update.UpdateMaintenanceRequest;
import sametyilmaz.rentacar.business.dto.requests.update.UpdateMaintenanceStatusForCarRequest;
import sametyilmaz.rentacar.business.dto.responses.create.CreateMaintenanceResponse;
import sametyilmaz.rentacar.business.dto.responses.get.GetAllMaintenancesResponse;
import sametyilmaz.rentacar.business.dto.responses.get.GetMaintenanceResponse;
import sametyilmaz.rentacar.business.dto.responses.update.UpdateMaintenanceResponse;
import sametyilmaz.rentacar.business.dto.responses.update.UpdateMaintenanceStatusForCarResponse;
import sametyilmaz.rentacar.entities.Car;
import sametyilmaz.rentacar.entities.Maintenance;
import sametyilmaz.rentacar.repository.MaintenanceRepository;

import java.util.Date;
import java.util.List;

import static sametyilmaz.rentacar.entities.enums.State.*;

@Service
@AllArgsConstructor
public class MaintenanceManager implements MaintenanceService {

    private final MaintenanceRepository repository;
    private final ModelMapper mapper;
    private final CarService carService;

    @Override
    public CreateMaintenanceResponse add(CreateMaintenanceRequest request) {
        carService.checkIfCarExists(request.getCarId());
        Car car = mapper.map(carService.getById(request.getCarId()),Car.class);
        validateMaintenance(car);

        Maintenance maintenance = mapper.map(request,Maintenance.class);
        Date date = new Date();
        maintenance.setId(0);
        maintenance.setSendDate(date);
        repository.save(maintenance);
        sendMaintenance(car);
        CreateMaintenanceResponse response = mapper.map(maintenance,CreateMaintenanceResponse.class);
        return response;
    }

    @Override
    public UpdateMaintenanceResponse update(int id, UpdateMaintenanceRequest request) {
        checkIfMaintenanceAvailable(id);
        Maintenance maintenance = mapper.map(request,Maintenance.class);
        repository.save(maintenance);
        UpdateMaintenanceResponse respond = mapper.map(maintenance, UpdateMaintenanceResponse.class);
        return respond;
    }

    @Override
    public GetMaintenanceResponse getById(int id) {
        Maintenance maintenance =repository.findById(id).orElseThrow();
        GetMaintenanceResponse response = mapper.map(maintenance, GetMaintenanceResponse.class);
        return response;
    }

    @Override
    public List<GetAllMaintenancesResponse> getAll() {
        List<Maintenance> maintenances = repository.findAll();
        List<GetAllMaintenancesResponse> responses = maintenances.stream()
                .map(maintenance -> mapper.map(maintenance, GetAllMaintenancesResponse.class)).toList();
        return responses;
    }

    @Override
    public UpdateMaintenanceStatusForCarResponse returnFromMaintenance(int id, UpdateMaintenanceStatusForCarRequest request) {
        Car car = mapper.map(carService.getById(request.getCarId()),Car.class);
        checkIfAvailableForReturningFromMaintenance(car);
        Maintenance maintenance = mapper.map(getById(id),Maintenance.class);
        maintenance.setId(id);
        Date date = new Date();
        maintenance.setReturnDate(date);
        repository.save(maintenance);
        returnFromMaintenance(car);
        UpdateMaintenanceStatusForCarResponse response = mapper.map(maintenance,UpdateMaintenanceStatusForCarResponse.class);
        return response;
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    public void validateMaintenance(Car car) {
        checkIfCarRentedforMaintenance(car);
        checkIfCarAvailableforMaintenance(car);
    }

    public void checkIfCarAvailableforMaintenance(Car car) {
        if (car.getState().equals(MAINTANCE)) throw new RuntimeException("Araç zaten bakımda");
    }

    public void checkIfCarRentedforMaintenance(Car car) {
        if (car.getState().equals(RENTED)) throw new RuntimeException("Araç şuan kirada");
    }
    public void sendMaintenance(Car car){
        car.setState(MAINTANCE);
        carService.update(car.getId(),mapper.map(car, UpdateCarRequest.class));

    }
    public void returnFromMaintenance(Car car){
        car.setState(AVAILABLE);
        carService.update(car.getId(),mapper.map(car, UpdateCarRequest.class));
    }
    public void checkIfMaintenanceAvailable(int id){
        if (!repository.existsById(id)) throw new RuntimeException("Bakım kaydı bulunamadı");
    }
    public void checkIfCarIsAvailable(Car car){
        if (car.getState().equals(AVAILABLE)) throw new RuntimeException("Araç zaten kiralanmaya hazır.");
    }
    public void checkIfAvailableForReturningFromMaintenance(Car car){
        checkIfCarIsAvailable(car);
        checkIfCarRentedforMaintenance(car);
    }
}
