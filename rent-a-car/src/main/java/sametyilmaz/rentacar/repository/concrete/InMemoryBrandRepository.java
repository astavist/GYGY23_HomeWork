package sametyilmaz.rentacar.repository.concrete;

import org.springframework.stereotype.Repository;
import sametyilmaz.rentacar.entities.concrete.Brand;
import sametyilmaz.rentacar.repository.abstracts.BrandRepository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryBrandRepository implements BrandRepository {

    List<Brand> brands;

    public InMemoryBrandRepository() {
        brands= new ArrayList<>();
        brands.add(new Brand(1,"Volvo"));
        brands.add(new Brand(2,"Volkswagen"));
        brands.add(new Brand(3,"Mercedes"));
    }

    @Override
    public List<Brand> getAll() {
        return brands;
    }

    @Override
    public Brand add(Brand brand) {
        brands.add(brand);
        return brand;
    }

    @Override
    public Brand getById(int id) {
        for (Brand brand : brands) {
            if (brand.getId() == id) {
                return brand;
            }
        }throw new RuntimeException("Ürün bulunamadı");
    }

    @Override
    public Brand update(int id, Brand brand) {
        return brands.set(id-1,brand);
    }

    @Override
    public void delete(int id) {
        brands.remove(id-1);

    }
}
