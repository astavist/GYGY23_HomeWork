package sametyilmaz.ecommerce.api.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sametyilmaz.ecommerce.business.abstracts.PaymentService;
import sametyilmaz.ecommerce.business.dto.requests.create.CreatePaymentRequest;
import sametyilmaz.ecommerce.business.dto.requests.update.UpdatePaymentRequest;
import sametyilmaz.ecommerce.business.dto.responses.create.CreatePaymentResponse;
import sametyilmaz.ecommerce.business.dto.responses.get.GetAllPaymentResponse;
import sametyilmaz.ecommerce.business.dto.responses.get.GetPaymentResponse;
import sametyilmaz.ecommerce.business.dto.responses.update.UpdatePaymentResponse;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/payments")
public class PaymentsController {
    private final PaymentService service;

    @GetMapping
    public List<GetAllPaymentResponse> getAll() {
        return service.getAll();
    }
    @GetMapping("/{id}")
    public GetPaymentResponse getById(@PathVariable int id){
        return service.getById(id);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatePaymentResponse add(@RequestBody CreatePaymentRequest request){
        return service.add(request);
    }
    @PutMapping("/{id}")
    public UpdatePaymentResponse update(@PathVariable int id,@RequestBody UpdatePaymentRequest request){
        return service.update(id,request);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        service.delete(id);
    }
}
