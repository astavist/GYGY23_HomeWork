package sametyilmaz.rentacar.business.concrete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sametyilmaz.rentacar.business.abstracts.BrandService;
import sametyilmaz.rentacar.entities.concrete.Brand;
import sametyilmaz.rentacar.repository.abstracts.BrandRepository;

import java.util.List;
@Service
public class BrandManager implements BrandService {
    BrandRepository repository;

    @Autowired
    public BrandManager(BrandRepository repository) {
        this.repository=repository;
    }

    @Override
    public List<Brand> getAll() {
        if (repository.getAll().size() == 0) {
            throw new RuntimeException("Kayıtlı marka yok");
        }
        return repository.getAll();
    }

    @Override
    public Brand add(Brand brand) {
        checkIfBrandValid(brand);
        return repository.add(brand);
    }

    @Override
    public Brand getById(int id) {
        return repository.getById(id);
    }

    @Override
    public Brand update(int id, Brand brand) {
        return repository.update(id,brand);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }

    public void checkIfBrandValid(Brand brand) {
        for (Brand brand1:repository.getAll()) {
            if (brand1.getId() == brand.getId()) {
                throw new RuntimeException("Eklemeye çalıştığınız marka mevcut.");
            }
        }
    }
}
