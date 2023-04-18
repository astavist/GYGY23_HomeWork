package sametyilmaz.rentacar.business.abstracts;

import sametyilmaz.rentacar.business.dto.requests.create.CreateInvoiceRequest;
import sametyilmaz.rentacar.business.dto.requests.update.UpdateInvoiceRequest;
import sametyilmaz.rentacar.business.dto.responses.create.CreateInvoiceResponse;
import sametyilmaz.rentacar.business.dto.responses.get.invoice.GetAllInvoicesResponse;
import sametyilmaz.rentacar.business.dto.responses.get.invoice.GetInvoiceResponse;
import sametyilmaz.rentacar.business.dto.responses.update.UpdateInvoiceResponse;

import java.util.List;

public interface InvoiceService {
    List<GetAllInvoicesResponse> getAll();
    GetInvoiceResponse getById(int id);
    CreateInvoiceResponse add(CreateInvoiceRequest request);
    UpdateInvoiceResponse update(int id, UpdateInvoiceRequest request);
    void delete(int id);
}
