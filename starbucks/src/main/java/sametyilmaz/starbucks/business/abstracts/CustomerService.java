package sametyilmaz.starbucks.business.abstracts;


import sametyilmaz.starbucks.business.dto.request.SaveCustomerRequest;
import sametyilmaz.starbucks.business.dto.response.GetAllCustomersResponse;
import sametyilmaz.starbucks.business.dto.response.SaveCustomerResponse;

import java.util.List;

public interface CustomerService {
    SaveCustomerResponse save(SaveCustomerRequest request);
    List<GetAllCustomersResponse> getAll();
}
