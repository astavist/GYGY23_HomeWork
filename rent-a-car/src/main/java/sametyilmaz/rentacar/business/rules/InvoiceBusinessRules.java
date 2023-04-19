package sametyilmaz.rentacar.business.rules;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sametyilmaz.rentacar.common.constants.Messages;
import sametyilmaz.rentacar.core.exceptions.BusinessException;
import sametyilmaz.rentacar.repository.InvoiceRepository;

@Service
@AllArgsConstructor
public class InvoiceBusinessRules {
    private final InvoiceRepository repository;

    public void checkIfInvoiceExists(int id) {
        if (!repository.existsById(id)) {
            throw new BusinessException(Messages.Invoice.NotFound);
        }
    }
}
