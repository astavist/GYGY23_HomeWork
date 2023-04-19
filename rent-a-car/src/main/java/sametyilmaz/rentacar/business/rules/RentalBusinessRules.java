package sametyilmaz.rentacar.business.rules;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sametyilmaz.rentacar.common.constants.Messages;
import sametyilmaz.rentacar.core.exceptions.BusinessException;
import sametyilmaz.rentacar.entities.enums.State;
import sametyilmaz.rentacar.repository.RentalRepository;

@Service
@AllArgsConstructor
public class RentalBusinessRules {
    private final RentalRepository repository;

    public void checkIfRentalExists(int id){
        if(!repository.existsById(id)){
            throw new BusinessException(Messages.Rental.NotExists);
        }
    }

    public void checkIfCarAvailable(State state) {
        if(!state.equals(State.AVAILABLE)){
            throw new BusinessException(Messages.Car.NotAvailable);
        }
    }
}
