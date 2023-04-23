package sametyilmaz.ecommerce.business.rules;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import sametyilmaz.ecommerce.entities.Product;
import sametyilmaz.ecommerce.repository.SaleRepository;

@Service
@AllArgsConstructor
public class SaleBusinessRules {
    private final SaleRepository repository;
    private final ModelMapper mapper;

    public void checkProductForSale(int id) {
        checkIfProductAvailable(id);
        checkQuantityOfProduct(id);
    }

    public void checkIfSaleExists(int id) {
        if (repository.existsById(id)) throw new RuntimeException("Sale is not found");
    }
    public void checkIfProductAvailable(int id){
        Product product = mapper.map(repository.findById(id),Product.class);
        if (!product.getStatus().toString().equals("ACTIVE")) throw new RuntimeException("Product status is passive");
    }

    public void checkQuantityOfProduct(int id) {
        Product product = mapper.map(repository.findById(id),Product.class);
        if (product.getQuantity() == 0) throw new RuntimeException("Product quantity is 0");
    }


}
