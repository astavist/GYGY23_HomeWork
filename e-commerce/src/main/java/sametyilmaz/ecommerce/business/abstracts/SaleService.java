package sametyilmaz.ecommerce.business.abstracts;

import sametyilmaz.ecommerce.business.dto.requests.create.CreateSaleRequest;
import sametyilmaz.ecommerce.business.dto.responses.create.CreateSaleResponse;
import sametyilmaz.ecommerce.business.dto.responses.get.GetSaleResponse;
import sametyilmaz.ecommerce.business.dto.responses.get.GetlAllSalesResponse;
import sametyilmaz.ecommerce.business.dto.responses.update.UpdateSaleResponse;

import java.util.List;

public interface SaleService {
    List<GetlAllSalesResponse> getAll();
    GetSaleResponse getById(int id);
    CreateSaleResponse add(CreateSaleRequest request);
    UpdateSaleResponse update(int id, CreateSaleRequest request);

    void delete(int id);
}
