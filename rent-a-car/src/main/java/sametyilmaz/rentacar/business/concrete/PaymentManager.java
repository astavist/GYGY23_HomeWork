package sametyilmaz.rentacar.business.concrete;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import sametyilmaz.rentacar.business.abstracts.PaymentService;
import sametyilmaz.rentacar.business.abstracts.PosService;
import sametyilmaz.rentacar.business.dto.requests.create.CreatePaymentRequest;
import sametyilmaz.rentacar.business.dto.requests.update.UpdatePaymentRequest;
import sametyilmaz.rentacar.business.dto.responses.create.CreatePaymentResponse;
import sametyilmaz.rentacar.business.dto.responses.get.payment.GetAllPaymentsResponse;
import sametyilmaz.rentacar.business.dto.responses.get.payment.GetPaymentResponse;
import sametyilmaz.rentacar.business.dto.responses.update.UpdatePaymentResponse;
import sametyilmaz.rentacar.business.rules.PaymentBusinessRules;
import sametyilmaz.rentacar.common.dto.CreateRentalPaymentRequest;
import sametyilmaz.rentacar.entities.Payment;
import sametyilmaz.rentacar.repository.PaymentRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class PaymentManager implements PaymentService {
    private final PaymentRepository repository;
    private final ModelMapper mapper;
    private final PosService posService;
    private final PaymentBusinessRules rules;

    @Override
    public List<GetAllPaymentsResponse> getAll() {
        List<Payment> payments = repository.findAll();
        List<GetAllPaymentsResponse> response = payments
                .stream().map(payment -> mapper.map(payment,GetAllPaymentsResponse.class)).toList();
        return response;
    }

    @Override
    public GetPaymentResponse getById(int id) {
        rules.checkIfPaymentExists(id);
        Payment payment = repository.findById(id).orElseThrow();
        GetPaymentResponse response = mapper.map(payment,GetPaymentResponse.class);
        return response;
    }

    @Override
    public CreatePaymentResponse add(CreatePaymentRequest request) {
        rules.checkIfCardExists(request.getCardNumber()); //kart var mı yok mu
        Payment payment = mapper.map(request,Payment.class);
        payment.setId(0);
        repository.save(payment);
        CreatePaymentResponse response = mapper.map(payment,CreatePaymentResponse.class);
        return response;
    }

    @Override
    public UpdatePaymentResponse update(int id, UpdatePaymentRequest request) {
        rules.checkIfPaymentExists(id); //ödeme bilgisi var mı yok mu
        Payment payment = mapper.map(request,Payment.class);
        payment.setId(id);
        repository.save(payment);
        UpdatePaymentResponse response = mapper.map(payment,UpdatePaymentResponse.class);
        return response;
    }

    @Override
    public void delete(int id) {
        rules.checkIfPaymentExists(id); //ödeme bilgisi var mı yok mu
        repository.deleteById(id);
    }

    @Override
    public void processRentalPayment(CreateRentalPaymentRequest request) {
        rules.checkIfPaymentIsValid(request);
        Payment payment = repository.findByCardNumber(request.getCardNumber());
        rules.checkIfBalanceIdEnough(payment.getBalance(),request.getPrice());
        posService.pay(); //fakepos
        payment.setBalance(payment.getBalance()-request.getPrice());
        repository.save(payment);
    }
}
