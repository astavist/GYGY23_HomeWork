package sametyilmaz.ecommerce.business.abstracts;

import sametyilmaz.ecommerce.business.dto.requests.create.CreateProductRequest;
import sametyilmaz.ecommerce.business.dto.requests.update.UpdateProductRequest;
import sametyilmaz.ecommerce.business.dto.responses.*;
import sametyilmaz.ecommerce.business.dto.responses.create.CreateProductResponse;
import sametyilmaz.ecommerce.business.dto.responses.get.GetAllProductsResponse;
import sametyilmaz.ecommerce.business.dto.responses.get.GetProductResponse;
import sametyilmaz.ecommerce.business.dto.responses.update.UpdateProductResponse;

import java.util.List;

public interface ProductService {
    List<GetAllProductsResponse> getAll(Boolean choice);

    GetProductResponse getById(int id);

    CreateProductResponse add(CreateProductRequest request);

    UpdateProductResponse update(int id, UpdateProductRequest request);

    StatusProductResponse statusChanger(int id);
    void delete(int id);
}
