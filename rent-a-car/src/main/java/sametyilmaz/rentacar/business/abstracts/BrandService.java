package sametyilmaz.rentacar.business.abstracts;

import sametyilmaz.rentacar.entities.Brand;

import java.util.List;

public interface BrandService {
    List<Brand> getAll();
    Brand getById(int id);
    Brand add(Brand brand);
    Brand update(int id,Brand brand);
    void delete(int id);

}
