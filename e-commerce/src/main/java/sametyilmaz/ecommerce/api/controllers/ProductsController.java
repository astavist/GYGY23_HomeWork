package sametyilmaz.ecommerce.api.controllers;

import lombok.AllArgsConstructor;
import sametyilmaz.ecommerce.business.abstracts.ProductService;
import sametyilmaz.ecommerce.business.dto.requests.CreateProductRequest;
import sametyilmaz.ecommerce.business.dto.requests.UpdateProductRequest;
import sametyilmaz.ecommerce.business.dto.responses.CreateProductResponse;
import sametyilmaz.ecommerce.business.dto.responses.GetAllProductsResponse;
import sametyilmaz.ecommerce.business.dto.responses.GetProductResponse;
import sametyilmaz.ecommerce.business.dto.responses.UpdateProductResponse;
import sametyilmaz.ecommerce.entities.Product;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductsController {
    private final ProductService service;

//    mapping

    @GetMapping
    public List<GetAllProductsResponse> getAll() {
        return service.getAll();
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
    public UpdateProductResponse update(@PathVariable int id,@RequestBody UpdateProductRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }

}
