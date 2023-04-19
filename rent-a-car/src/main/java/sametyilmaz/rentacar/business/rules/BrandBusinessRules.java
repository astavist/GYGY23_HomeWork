package sametyilmaz.rentacar.business.rules;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sametyilmaz.rentacar.common.constants.Messages;
import sametyilmaz.rentacar.core.exceptions.BusinessException;
import sametyilmaz.rentacar.repository.BrandRepository;

@Service
@AllArgsConstructor
public class BrandBusinessRules {
    private final BrandRepository repository;

    public void checkIfBrandExists(int id) {
        if (!repository.existsById(id)) throw new RuntimeException("Marka bulunamadı");
    }

    public void checkIfBrandExistByName(String name) {
        if (repository.existsByNameIgnoreCase(name)) {
            throw new BusinessException(Messages.Brand.Exists);
        }
    }
}
