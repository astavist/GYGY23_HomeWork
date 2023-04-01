package sametyilmaz.rentacar.business.concrete;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import sametyilmaz.rentacar.business.abstracts.CarService;
import sametyilmaz.rentacar.business.dto.requests.create.CreateCarRequest;
import sametyilmaz.rentacar.business.dto.requests.update.UpdateCarRequest;
import sametyilmaz.rentacar.business.dto.responses.create.CreateCarResponse;
import sametyilmaz.rentacar.business.dto.responses.get.GetAllCarsResponse;
import sametyilmaz.rentacar.business.dto.responses.get.GetCarResponse;
import sametyilmaz.rentacar.business.dto.responses.update.UpdateCarResponse;
import sametyilmaz.rentacar.entities.Car;
import sametyilmaz.rentacar.repository.CarRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class CarManager implements CarService {
    private final CarRepository carRepository;
    private final ModelMapper mapper;

    @Override
    public List<GetAllCarsResponse> getAll() {
        List<GetAllCarsResponse> response = carRepository.findAll().stream()
                .map(car -> mapper.map(car, GetAllCarsResponse.class)).toList();
        return response;
    }

    @Override
    public GetCarResponse getById(int id) {
        checkIfCarExists(id);
        return mapper.map(carRepository.findById(id).orElseThrow(), GetCarResponse.class);
    }

    @Override
    public CreateCarResponse add(CreateCarRequest request) {
        Car car = mapper.map(request,Car.class);
        car.setId(0);
        carRepository.save(car);
        return mapper.map(car,CreateCarResponse.class);
    }

    @Override
    public UpdateCarResponse update(int id, UpdateCarRequest request) {
        checkIfCarExists(id);
        Car car = mapper.map(request,Car.class);
        car.setId(id);
        carRepository.save(car);
        return mapper.map(car,UpdateCarResponse.class);
    }

    @Override
    public void delete(int id) {
        checkIfCarExists(id);
        carRepository.deleteById(id);

    }

    public void checkIfCarExists(int id) {
        if (!carRepository.existsById(id)) throw new RuntimeException("Marka bulunamadı");
    }
}
