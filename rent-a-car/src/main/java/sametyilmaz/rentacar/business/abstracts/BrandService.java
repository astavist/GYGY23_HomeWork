package sametyilmaz.rentacar.business.abstracts;

import sametyilmaz.rentacar.business.dto.requests.create.CreateBrandRequest;
import sametyilmaz.rentacar.business.dto.requests.update.UpdateBrandRequest;
import sametyilmaz.rentacar.business.dto.responses.create.CreateBrandResponse;
import sametyilmaz.rentacar.business.dto.responses.get.brand.GetAllBrandsResponse;
import sametyilmaz.rentacar.business.dto.responses.get.brand.GetBrandResponse;
import sametyilmaz.rentacar.business.dto.responses.update.UpdateBrandResponse;

import java.util.List;

public interface BrandService {
    List<GetAllBrandsResponse> getAll();
    GetBrandResponse getById(int id);
    CreateBrandResponse add(CreateBrandRequest request);
    UpdateBrandResponse update(int id, UpdateBrandRequest request);
    void delete(int id);

}
