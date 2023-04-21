package sametyilmaz.ecommerce.business.abstracts;

import sametyilmaz.ecommerce.business.dto.requests.CreateProductRequest;
import sametyilmaz.ecommerce.business.dto.requests.UpdateProductRequest;
import sametyilmaz.ecommerce.business.dto.responses.CreateProductResponse;
import sametyilmaz.ecommerce.business.dto.responses.GetAllProductsResponse;
import sametyilmaz.ecommerce.business.dto.responses.GetProductResponse;
import sametyilmaz.ecommerce.business.dto.responses.UpdateProductResponse;
import sametyilmaz.ecommerce.entities.Product;

import java.util.List;

public interface ProductService {
    List<GetAllProductsResponse> getAll();

    GetProductResponse getById(int id);

    CreateProductResponse add(CreateProductRequest request);

    UpdateProductResponse update(int id, UpdateProductRequest request);

    void delete(int id);
}
