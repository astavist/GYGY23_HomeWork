package sametyilmaz.ecommerce.business.concretes;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import sametyilmaz.ecommerce.business.abstracts.SaleService;
import sametyilmaz.ecommerce.business.dto.requests.create.CreateSaleRequest;
import sametyilmaz.ecommerce.business.dto.responses.create.CreateSaleResponse;
import sametyilmaz.ecommerce.business.dto.responses.get.GetSaleResponse;
import sametyilmaz.ecommerce.business.dto.responses.get.GetlAllSalesResponse;
import sametyilmaz.ecommerce.business.dto.responses.update.UpdateSaleResponse;
import sametyilmaz.ecommerce.entities.Sale;
import sametyilmaz.ecommerce.repository.SaleRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class SaleManager implements SaleService {
    private ModelMapper mapper;
    private SaleRepository repository;
    @Override
    public List<GetlAllSalesResponse> getAll() {
        List<Sale> sales = repository.findAll();
        List<GetlAllSalesResponse> responses = sales.stream().map(sale -> mapper.map(sale,GetlAllSalesResponse.class)).toList();
        return responses;
    }

    @Override
    public GetSaleResponse getById(int id) {
        Sale sales = mapper.map(repository.findById(id),Sale.class);
        GetSaleResponse response = mapper.map(sales,GetSaleResponse.class);
        return response;
    }

    @Override
    public CreateSaleResponse add(CreateSaleRequest request) {
        Sale sale = mapper.map(request,Sale.class);
        sale.setId(0);
        repository.save(sale);
        CreateSaleResponse response = mapper.map(sale,CreateSaleResponse.class);
        return response;
    }

    @Override
    public UpdateSaleResponse update(int id, CreateSaleRequest request) {
        Sale sale = mapper.map(request,Sale.class);
        sale.setId(id);
        repository.save(sale);
        UpdateSaleResponse response = mapper.map(sale, UpdateSaleResponse.class);
        return response;
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
