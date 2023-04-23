package sametyilmaz.ecommerce.business.abstracts;

import sametyilmaz.ecommerce.business.dto.requests.create.CreateSaleRequest;
import sametyilmaz.ecommerce.business.dto.requests.update.UpdateSaleRequest;
import sametyilmaz.ecommerce.business.dto.responses.create.CreateSaleResponse;
import sametyilmaz.ecommerce.business.dto.responses.get.GetSaleResponse;
import sametyilmaz.ecommerce.business.dto.responses.get.GetAllSalesResponse;
import sametyilmaz.ecommerce.business.dto.responses.update.UpdateSaleResponse;

import java.util.List;

public interface SaleService {
    List<GetAllSalesResponse> getAll();
    GetSaleResponse getById(int id);
    CreateSaleResponse add(CreateSaleRequest request);
    UpdateSaleResponse update(int id, UpdateSaleRequest request);

    void delete(int id);
}
