package sametyilmaz.rentacar.business.concrete;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import sametyilmaz.rentacar.business.abstracts.BrandService;
import sametyilmaz.rentacar.business.dto.requests.create.CreateBrandRequest;
import sametyilmaz.rentacar.business.dto.requests.update.UpdateBrandRequest;
import sametyilmaz.rentacar.business.dto.responses.create.CreateBrandResponse;
import sametyilmaz.rentacar.business.dto.responses.get.brand.GetAllBrandsResponse;
import sametyilmaz.rentacar.business.dto.responses.get.brand.GetBrandResponse;
import sametyilmaz.rentacar.business.dto.responses.update.UpdateBrandResponse;
import sametyilmaz.rentacar.business.rules.BrandBusinessRules;
import sametyilmaz.rentacar.entities.Brand;
import sametyilmaz.rentacar.repository.BrandRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class BrandManager implements BrandService {
    private final BrandRepository repository;
    private final ModelMapper mapper;
    private final BrandBusinessRules rules;

    @Override
    @Cacheable(value = "brand_list")
    public List<GetAllBrandsResponse> getAll() {
        List<Brand> brands = repository.findAll();
        List<GetAllBrandsResponse> response = brands
                .stream()
                .map(brand -> mapper.map(brand, GetAllBrandsResponse.class)).toList();
        return response;
    }

    @Override
    public GetBrandResponse getById(int id) {
        rules.checkIfBrandExists(id);
        Brand brand = repository.findById(id).orElseThrow();
        GetBrandResponse response = mapper.map(brand,GetBrandResponse.class);
        return response;
    }

    @Override
    @CacheEvict(value = "brand_list",allEntries = true)
    public CreateBrandResponse add(CreateBrandRequest request) {
//        Brand brand = new Brand();
//        brand.setName(request.getName());
//        repository.save(brand);

//        CreateBrandResponse response = new CreateBrandResponse();
//        response.setId(brand.getId());
//        response.setName(brand.getName());
//        return response;
        rules.checkIfBrandExistByName(request.getName());

        Brand brand = mapper.map(request,Brand.class);
        brand.setId(0);
        repository.save(brand);

        CreateBrandResponse response = mapper.map(brand,CreateBrandResponse.class);
        return response;
    }

    @Override
    public UpdateBrandResponse update(int id, UpdateBrandRequest request) {
        rules.checkIfBrandExists(id);

        Brand brand = mapper.map(request,Brand.class);
        brand.setId(id);
        repository.save(brand);

        UpdateBrandResponse response = mapper.map(brand,UpdateBrandResponse.class);
        return response;

    }

    @Override
    public void delete(int id) {
        rules.checkIfBrandExists(id);
        repository.deleteById(id);
    }
}
