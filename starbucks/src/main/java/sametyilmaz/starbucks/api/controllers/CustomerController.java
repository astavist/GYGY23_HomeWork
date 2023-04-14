package sametyilmaz.starbucks.api.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sametyilmaz.starbucks.business.abstracts.CustomerService;
import sametyilmaz.starbucks.business.dto.request.SaveCustomerRequest;
import sametyilmaz.starbucks.business.dto.response.GetAllCustomersResponse;
import sametyilmaz.starbucks.business.dto.response.SaveCustomerResponse;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerService service;
    @PostMapping("")
    public ResponseEntity<SaveCustomerResponse> save(@RequestBody SaveCustomerRequest request){
        SaveCustomerResponse response = service.save(request);
        return new ResponseEntity<SaveCustomerResponse>(response,HttpStatus.CREATED);
    }

    @GetMapping
    public List<GetAllCustomersResponse> getAll() {
        return service.getAll();
    }
}
