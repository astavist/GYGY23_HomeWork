package sametyilmaz.rentacar.business.rules;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sametyilmaz.rentacar.common.constants.Messages;
import sametyilmaz.rentacar.core.exceptions.BusinessException;
import sametyilmaz.rentacar.repository.ModelRepository;

@Service
@AllArgsConstructor
public class ModelBusinessRules {
    private final ModelRepository repository;

    public void checkIfModelExists(int id) {
        if (!repository.existsById(id)) {
            throw new BusinessException(Messages.Model.NotExists);
        }
    }
}
