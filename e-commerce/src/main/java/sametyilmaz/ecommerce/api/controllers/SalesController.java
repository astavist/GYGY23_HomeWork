package sametyilmaz.ecommerce.api.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sametyilmaz.ecommerce.business.abstracts.SaleService;
import sametyilmaz.ecommerce.business.dto.requests.create.CreateSaleRequest;
import sametyilmaz.ecommerce.business.dto.responses.create.CreateSaleResponse;
import sametyilmaz.ecommerce.business.dto.responses.get.GetSaleResponse;
import sametyilmaz.ecommerce.business.dto.responses.get.GetlAllSalesResponse;
import sametyilmaz.ecommerce.business.dto.responses.update.UpdateSaleResponse;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/sales")
public class SalesController {
    private SaleService service;

    @GetMapping
    public List<GetlAllSalesResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetSaleResponse getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateSaleResponse add(@RequestBody CreateSaleRequest request) {
        return service.add(request);
    }
    @PutMapping("/{id}")
    public UpdateSaleResponse update(@PathVariable int id,@RequestBody CreateSaleRequest request) {
        return service.update(id,request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
}
