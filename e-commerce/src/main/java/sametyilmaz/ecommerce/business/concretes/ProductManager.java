package sametyilmaz.ecommerce.business.concretes;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import sametyilmaz.ecommerce.business.abstracts.ProductService;
import sametyilmaz.ecommerce.business.dto.requests.CreateProductRequest;
import sametyilmaz.ecommerce.business.dto.requests.UpdateProductRequest;
import sametyilmaz.ecommerce.business.dto.responses.CreateProductResponse;
import sametyilmaz.ecommerce.business.dto.responses.GetAllProductsResponse;
import sametyilmaz.ecommerce.business.dto.responses.GetProductResponse;
import sametyilmaz.ecommerce.business.dto.responses.UpdateProductResponse;
import sametyilmaz.ecommerce.business.rules.ProductBusinessRules;
import sametyilmaz.ecommerce.entities.Product;
import sametyilmaz.ecommerce.repository.ProductRepository;


import javax.sound.sampled.Port;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductManager implements ProductService {

    private final ProductRepository repository;
    private final ProductBusinessRules rules;
    private final ModelMapper mapper;


    private void validateProduct(Product product) {
        rules.checkIfPriceValid(product);
        rules.checkIfQuantityValid(product);
        rules.checkIfDescriptionValid(product);
    }

    @Override
    public List<GetAllProductsResponse> getAll() {
        List<Product> products = repository.findAll();
        List<GetAllProductsResponse> response = products
                .stream().map(product -> mapper.map(product,GetAllProductsResponse.class)).toList();
        return response;
    }

    @Override
    public GetProductResponse getById(int id) {
        rules.checkIfProductExists(id);
        Product product = repository.findById(id).orElseThrow();
        GetProductResponse response = mapper.map(product,GetProductResponse.class);
        return response;
    }

    @Override
    public CreateProductResponse add(CreateProductRequest request) {
        Product product = mapper.map(request,Product.class);
        product.setId(0);
        validateProduct(product);
        repository.save(product);
        CreateProductResponse response = mapper.map(product,CreateProductResponse.class);
        return response;
    }

    @Override
    public UpdateProductResponse update(int id, UpdateProductRequest request) {
        rules.checkIfProductExists(id);
        Product product = mapper.map(request,Product.class);
        validateProduct(product);
        product.setId(id);
        repository.save(product);
        UpdateProductResponse response = mapper.map(product,UpdateProductResponse.class);
        return response;
    }

    @Override
    public void delete(int id) {
        rules.checkIfProductExists(id);
        repository.deleteById(id);
    }
}