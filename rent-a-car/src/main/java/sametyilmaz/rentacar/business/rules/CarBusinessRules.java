package sametyilmaz.rentacar.business.rules;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sametyilmaz.rentacar.common.constants.Messages;
import sametyilmaz.rentacar.core.exceptions.BusinessException;
import sametyilmaz.rentacar.repository.CarRepository;

@Service
@AllArgsConstructor
public class CarBusinessRules {
    private final CarRepository repository;

    public void checkIfCarExists(int id) {
        if (!repository.existsById(id)) {
            throw new BusinessException(Messages.Car.NotExists);
        }
    }
}
