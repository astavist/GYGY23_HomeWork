package sametyilmaz.ecommerce.api.controllers;

import lombok.AllArgsConstructor;
import sametyilmaz.ecommerce.business.abstracts.ProductService;
import sametyilmaz.ecommerce.business.dto.requests.create.CreateProductRequest;
import sametyilmaz.ecommerce.business.dto.requests.update.UpdateProductRequest;
import sametyilmaz.ecommerce.business.dto.responses.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sametyilmaz.ecommerce.business.dto.responses.create.CreateProductResponse;
import sametyilmaz.ecommerce.business.dto.responses.get.GetAllProductsResponse;
import sametyilmaz.ecommerce.business.dto.responses.get.GetProductResponse;
import sametyilmaz.ecommerce.business.dto.responses.update.UpdateProductResponse;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductsController {
    private final ProductService service;

//    mapping

    @GetMapping
    public List<GetAllProductsResponse> getAll(Boolean choice) {
        return service.getAll(choice);
    }

    @GetMapping("/{id}")
    public GetProductResponse getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateProductResponse add(@RequestBody CreateProductRequest request) {
        return service.add(request);
    }

    @PutMapping("/{id}")
    public UpdateProductResponse update(@PathVariable int id, @RequestBody UpdateProductRequest request) {
        return service.update(id, request);
    }

    @PutMapping("/changer/{id}")
    public StatusProductResponse changer(@PathVariable int id) {
        return service.statusChanger(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }

}
