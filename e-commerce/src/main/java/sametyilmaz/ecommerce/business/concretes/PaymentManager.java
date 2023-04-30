package sametyilmaz.ecommerce.business.concretes;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import sametyilmaz.ecommerce.business.abstracts.PaymentService;
import sametyilmaz.ecommerce.business.dto.requests.create.CreatePaymentRequest;
import sametyilmaz.ecommerce.business.dto.requests.update.UpdatePaymentRequest;
import sametyilmaz.ecommerce.business.dto.responses.create.CreatePaymentResponse;
import sametyilmaz.ecommerce.business.dto.responses.get.GetPaymentResponse;
import sametyilmaz.ecommerce.business.dto.responses.get.GetAllPaymentResponse;
import sametyilmaz.ecommerce.business.dto.responses.get.GetAllSalesResponse;
import sametyilmaz.ecommerce.business.dto.responses.update.UpdatePaymentResponse;
import sametyilmaz.ecommerce.business.rules.PaymentBusinessRules;
import sametyilmaz.ecommerce.common.dto.CreateSalePaymentRequest;
import sametyilmaz.ecommerce.entities.Payment;
import sametyilmaz.ecommerce.repository.PaymentRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class PaymentManager implements PaymentService {
    private final ModelMapper mapper;
    private final PaymentBusinessRules rules;
    private final PaymentRepository repository;
    @Override
    public List<GetAllPaymentResponse> getAll() {
        List<Payment> payments = repository.findAll();
        List<GetAllPaymentResponse> response = payments
                .stream().map(payment -> mapper.map(payment, GetAllPaymentResponse.class)).toList();
        return response;
    }

    @Override
    public GetPaymentResponse getById(int id) {
        Payment payment = mapper.map(repository.findById(id),Payment.class);
        GetPaymentResponse response = mapper.map(payment,GetPaymentResponse.class);
        return response;
    }

    @Override
    public CreatePaymentResponse add(CreatePaymentRequest request) {
        Payment payment = mapper.map(request,Payment.class);
        payment.setId(0);
        repository.save(payment);
        CreatePaymentResponse response = mapper.map(payment,CreatePaymentResponse.class);
        return response;
    }

    @Override
    public UpdatePaymentResponse update(int id, UpdatePaymentRequest request) {
        Payment payment = mapper.map(request,Payment.class);
        payment.setId(id);
        repository.save(payment);
        UpdatePaymentResponse response = mapper.map(payment,UpdatePaymentResponse.class);
        return response;
    }

    @Override
    public void processRentalPayment(CreateSalePaymentRequest request) {
        rules.checkIfPaymentIsValid(request);
        Payment payment = repository.findByCardNumber(request.getCardNumber());
        rules.checkIfBalanceIsEnough(request.getBalance(),);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
