package sametyilmaz.ecommerce.business.abstracts;

import sametyilmaz.ecommerce.business.dto.requests.create.CreatePaymentRequest;
import sametyilmaz.ecommerce.business.dto.requests.update.UpdatePaymentRequest;
import sametyilmaz.ecommerce.business.dto.responses.create.CreatePaymentResponse;
import sametyilmaz.ecommerce.business.dto.responses.get.GetPaymentResponse;
import sametyilmaz.ecommerce.business.dto.responses.get.GetAllPaymentResponse;
import sametyilmaz.ecommerce.business.dto.responses.update.UpdatePaymentResponse;
import sametyilmaz.ecommerce.common.dto.CreateSalePaymentRequest;

import java.util.List;

public interface PaymentService {
    List<GetAllPaymentResponse> getAll();
    GetPaymentResponse getById(int id);
    CreatePaymentResponse add(CreatePaymentRequest request);
    UpdatePaymentResponse update(int id, UpdatePaymentRequest request);

    void processRentalPayment(CreateSalePaymentRequest request);

    void delete(int id);
}
