package sametyilmaz.rentacar.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sametyilmaz.rentacar.business.abstracts.BrandService;
import sametyilmaz.rentacar.entities.concrete.Brand;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
public class BrandsController {
    private final BrandService service;


    @Autowired
    public BrandsController(BrandService service) {
        this.service = service;
    }

    @GetMapping
    public List<Brand> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Brand add(Brand brand) {
        return service.add(brand);
    }

    @GetMapping("/{id}")
    public Brand getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Brand update(@PathVariable int id,@RequestBody Brand brand) {
        return service.update(id,brand);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
}
