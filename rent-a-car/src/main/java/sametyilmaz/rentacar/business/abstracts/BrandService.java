package sametyilmaz.rentacar.business.abstracts;

import sametyilmaz.rentacar.entities.concrete.Brand;

import java.util.List;

public interface BrandService {
    List<Brand> getAll();
    Brand add(Brand brand);
    Brand getById(int id);
    Brand update(int id,Brand brand);
    void delete(int id);
}
