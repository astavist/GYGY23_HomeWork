package sametyilmaz.starbucks.business.concrete;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import sametyilmaz.starbucks.adapters.MernisCheckAdapter;
import sametyilmaz.starbucks.business.abstracts.CustomerService;
import sametyilmaz.starbucks.business.dto.request.SaveCustomerRequest;
import sametyilmaz.starbucks.business.dto.response.GetAllCustomersResponse;
import sametyilmaz.starbucks.business.dto.response.SaveCustomerResponse;
import sametyilmaz.starbucks.entities.Customer;
import sametyilmaz.starbucks.repository.CustomerRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService {
    private final CustomerRepository repository;
    private final ModelMapper mapper;
    private final MernisCheckAdapter mernis;

    @Override
    public SaveCustomerResponse save(SaveCustomerRequest request) {
        checkPersonIsReal(request);
        Customer customer = mapper.map(request, Customer.class);
        repository.save(customer);
        return mapper.map(customer, SaveCustomerResponse.class);
    }

    @Override
    public List<GetAllCustomersResponse> getAll() {
        List<Customer> customers = repository.findAll();
        List<GetAllCustomersResponse> response = customers.stream().map(customer -> mapper.map(customer,GetAllCustomersResponse.class)).toList();
        return response;
    }

    private boolean checkPersonIsReal(SaveCustomerRequest request)  {
        try {
            if(!mernis.checkPersonIsReal(request)) throw new RuntimeException("Bu Kullanıcı Doğrulanamadı!");
            return true;
        }
        catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
