package sametyilmaz.rentacar.business.concrete;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import sametyilmaz.rentacar.business.abstracts.CarService;
import sametyilmaz.rentacar.business.abstracts.MaintenanceService;
import sametyilmaz.rentacar.business.dto.requests.create.CreateMaintenanceRequest;
import sametyilmaz.rentacar.business.dto.requests.create.CreateReturnMaintenanceRequest;
import sametyilmaz.rentacar.business.dto.requests.update.UpdateCarRequest;
import sametyilmaz.rentacar.business.dto.requests.update.UpdateMaintenanceRequest;
import sametyilmaz.rentacar.business.dto.responses.create.CreateMaintenanceResponse;
import sametyilmaz.rentacar.business.dto.responses.create.CreateReturnMaintenanceResponse;
import sametyilmaz.rentacar.business.dto.responses.get.GetAllMaintenanceResponse;
import sametyilmaz.rentacar.business.dto.responses.get.GetMaintenanceResponse;
import sametyilmaz.rentacar.business.dto.responses.update.UpdateMaintenanceResponse;
import sametyilmaz.rentacar.entities.Car;
import sametyilmaz.rentacar.entities.Maintenance;
import sametyilmaz.rentacar.repository.MaintenanceRepository;

import java.util.Date;
import java.util.List;

import static sametyilmaz.rentacar.entities.enums.State.*;

@Service
@AllArgsConstructor
public class MaintenanceManager implements MaintenanceService {

    private final MaintenanceRepository maintenanceRepository;
    private final ModelMapper mapper;
    private final CarService carService;


    @Override
    public List<GetAllMaintenanceResponse> getAll() {
        List<Maintenance> maintenances = maintenanceRepository.findAll();
        List<GetAllMaintenanceResponse> responses = maintenances.stream()
                .map(maintenance -> mapper.map(maintenance,GetAllMaintenanceResponse.class)).toList();
        return responses;
    }

    @Override
    public GetMaintenanceResponse getById(int id) {
        return mapper.map(maintenanceRepository.findById(id).orElseThrow(), GetMaintenanceResponse.class);
    }

    @Override
    public CreateMaintenanceResponse add(CreateMaintenanceRequest request) {
        carService.checkIfCarExists(request.getCarId());
        Car car = mapper.map(carService.getById(request.getCarId()),Car.class);
        validateMaintenance(car);

        Maintenance maintenance = mapper.map(request,Maintenance.class);
        maintenance.setId(0);
        Date date = new Date();
        maintenance.setSendDate(date);
//        maintenance.setCar(car);
        Maintenance createdMaintenance = maintenanceRepository.save(maintenance);
        sendMaintenance(car);
        CreateMaintenanceResponse response = mapper.map(createdMaintenance,CreateMaintenanceResponse.class);
        return response;
    }

    @Override
    public UpdateMaintenanceResponse update(int id, UpdateMaintenanceRequest request) {
        Maintenance maintenance = mapper.map(request,Maintenance.class);
        maintenance.setId(id);
        maintenanceRepository.save(maintenance);
        return mapper.map(maintenanceRepository.save(maintenance),UpdateMaintenanceResponse.class);
    }

    @Override
    public CreateReturnMaintenanceResponse returnMaintenance(int id, CreateReturnMaintenanceRequest request) {
        Maintenance maintenance = mapper.map(getById(id),Maintenance.class);
        maintenance.setReturnDate(new Date());
        update(maintenance.getId(),mapper.map(maintenance,UpdateMaintenanceRequest.class));
        returnMaintenanceForCar(mapper.map(carService.getById(id),Car.class));
        return mapper.map(maintenance,CreateReturnMaintenanceResponse.class);
    }


    @Override
    public void delete(int id) {
        maintenanceRepository.deleteById(id);
    }

    public void sendMaintenance(Car car) {
        car.setState(MAINTANCE);
        carService.update(car.getId(),mapper.map(car, UpdateCarRequest.class));
    }

    public void returnMaintenanceForCar(Car car) {
        car.setState(AVAILABLE);
        carService.update(car.getId(),mapper.map(car, UpdateCarRequest.class));
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
}
