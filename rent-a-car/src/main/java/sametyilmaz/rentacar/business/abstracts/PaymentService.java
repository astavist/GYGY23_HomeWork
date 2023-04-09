package sametyilmaz.rentacar.business.abstracts;

import sametyilmaz.rentacar.business.dto.requests.create.CreatePaymentRequest;
import sametyilmaz.rentacar.business.dto.requests.update.UpdatePaymentRequest;
import sametyilmaz.rentacar.business.dto.responses.create.CreatePaymentResponse;
import sametyilmaz.rentacar.business.dto.responses.get.payment.GetAllPaymentsResponse;
import sametyilmaz.rentacar.business.dto.responses.get.payment.GetPaymentResponse;
import sametyilmaz.rentacar.business.dto.responses.update.UpdatePaymentResponse;
import sametyilmaz.rentacar.common.dto.CreateRentalPaymentRequest;

import java.util.List;

public interface PaymentService {
    List<GetAllPaymentsResponse> getAll();
    GetPaymentResponse getById(int id);
    CreatePaymentResponse add(CreatePaymentRequest request);
    UpdatePaymentResponse update(int id, UpdatePaymentRequest request);
    void delete(int id);
    void processRentalPayment(CreateRentalPaymentRequest request);

}
