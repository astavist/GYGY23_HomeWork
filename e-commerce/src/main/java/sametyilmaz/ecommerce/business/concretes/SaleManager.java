package sametyilmaz.ecommerce.business.concretes;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import sametyilmaz.ecommerce.business.abstracts.SaleService;
import sametyilmaz.ecommerce.business.dto.requests.create.CreateSaleRequest;
import sametyilmaz.ecommerce.business.dto.requests.update.UpdateSaleRequest;
import sametyilmaz.ecommerce.business.dto.responses.create.CreateSaleResponse;
import sametyilmaz.ecommerce.business.dto.responses.get.GetSaleResponse;
import sametyilmaz.ecommerce.business.dto.responses.get.GetAllSalesResponse;
import sametyilmaz.ecommerce.business.dto.responses.update.UpdateSaleResponse;
import sametyilmaz.ecommerce.business.rules.SaleBusinessRules;
import sametyilmaz.ecommerce.entities.Sale;
import sametyilmaz.ecommerce.repository.SaleRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class SaleManager implements SaleService {
    private ModelMapper mapper;
    private SaleBusinessRules rules;
    private SaleRepository repository;
    @Override
    public List<GetAllSalesResponse> getAll() {
        List<Sale> sales = repository.findAll();
        List<GetAllSalesResponse> responses = sales.stream().map(sale -> mapper.map(sale, GetAllSalesResponse.class)).toList();
        return responses;
    }

    @Override
    public GetSaleResponse getById(int id) {
        rules.checkIfSaleExists(id);
        Sale sales = mapper.map(repository.findById(id),Sale.class);
        GetSaleResponse response = mapper.map(sales,GetSaleResponse.class);
        return response;
    }

    @Override
    public CreateSaleResponse add(CreateSaleRequest request) {
        rules.checkProductForSale(request.getProductId());
        Sale sale = mapper.map(request,Sale.class);
        sale.setId(0);
        repository.save(sale);
        CreateSaleResponse response = mapper.map(sale,CreateSaleResponse.class);
        return response;
    }

    @Override
    public UpdateSaleResponse update(int id, UpdateSaleRequest request) {
        rules.checkIfSaleExists(id);
        Sale sale = mapper.map(request,Sale.class);
        sale.setId(id);
        repository.save(sale);
        UpdateSaleResponse response = mapper.map(sale, UpdateSaleResponse.class);
        return response;    }

    @Override
    public void delete(int id) {
        rules.checkIfSaleExists(id);
        repository.deleteById(id);
    }
}
