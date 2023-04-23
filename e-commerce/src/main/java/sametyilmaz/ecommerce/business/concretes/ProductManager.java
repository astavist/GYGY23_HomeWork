package sametyilmaz.ecommerce.business.concretes;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import sametyilmaz.ecommerce.business.abstracts.ProductService;
import sametyilmaz.ecommerce.business.dto.requests.create.CreateProductRequest;
import sametyilmaz.ecommerce.business.dto.requests.update.UpdateProductRequest;
import sametyilmaz.ecommerce.business.dto.responses.*;
import sametyilmaz.ecommerce.business.dto.responses.create.CreateProductResponse;
import sametyilmaz.ecommerce.business.dto.responses.get.GetAllProductsResponse;
import sametyilmaz.ecommerce.business.dto.responses.get.GetProductResponse;
import sametyilmaz.ecommerce.business.dto.responses.update.UpdateProductResponse;
import sametyilmaz.ecommerce.business.rules.ProductBusinessRules;
import sametyilmaz.ecommerce.entities.Product;
import sametyilmaz.ecommerce.entities.enums.ProductEnums;
import sametyilmaz.ecommerce.repository.ProductRepository;


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
    public List<GetAllProductsResponse> getAll(boolean choice) {
        List<Product> products = filterProductsByStatus(choice);
        List<GetAllProductsResponse> response = products
                .stream().map(product -> mapper.map(product, GetAllProductsResponse.class)).toList();
            return response;
    }

    @Override
    public GetProductResponse getById(int id) {
        rules.checkIfProductExists(id);
        Product product = repository.findById(id).orElseThrow();
        GetProductResponse response = mapper.map(product, GetProductResponse.class);
        return response;
    }

    @Override
    public CreateProductResponse add(CreateProductRequest request) {
        Product product = mapper.map(request, Product.class);
        product.setId(0);
        validateProduct(product);
        repository.save(product);
        CreateProductResponse response = mapper.map(product, CreateProductResponse.class);
        return response;
    }

    @Override
    public UpdateProductResponse update(int id, UpdateProductRequest request) {
        rules.checkIfProductExists(id);
        Product product = mapper.map(request, Product.class);
        validateProduct(product);
        product.setId(id);
        repository.save(product);
        UpdateProductResponse response = mapper.map(product, UpdateProductResponse.class);
        return response;
    }

    @Override
    public StatusProductResponse statusChanger(int id) {
        rules.checkIfProductExists(id);
        Product product = mapper.map(repository.findById(id), Product.class);
        if (product.getStatus().toString().equals("ACTIVE")) {
            product.setStatus(ProductEnums.PASSIVE);
        } else {
            product.setStatus(ProductEnums.ACTIVE);
        }
        product.setId(id);
        repository.save(product);
        StatusProductResponse response = mapper.map(product, StatusProductResponse.class);
        return response;
    }

    @Override
    public void delete(int id) {
        rules.checkIfProductExists(id);
        repository.deleteById(id);
    }

    public List<Product> filterProductsByStatus(boolean choice) {
        if (choice) {
            return repository.findAll();
        }
        else {
            return repository.findProductByStatus(ProductEnums.ACTIVE);
        }
    }
}