package sametyilmaz.rentacar.api.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sametyilmaz.rentacar.business.abstracts.ModelService;
import sametyilmaz.rentacar.business.dto.requests.create.CreateModelRequest;
import sametyilmaz.rentacar.business.dto.requests.update.UpdateModelRequest;
import sametyilmaz.rentacar.business.dto.responses.create.CreateModelResponse;
import sametyilmaz.rentacar.business.dto.responses.get.GetAllModelsResponse;
import sametyilmaz.rentacar.business.dto.responses.get.GetModelResponse;
import sametyilmaz.rentacar.business.dto.responses.update.UpdateModelResponse;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/models")
public class ModelController {
    private ModelService service;
    @GetMapping
    public List<GetAllModelsResponse> getAll(){
        return service.getAll();
    }
    @GetMapping("/{id}")
    public GetModelResponse getById(@PathVariable int id){
        return service.getById(id);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateModelResponse add(@RequestBody CreateModelRequest request){
        return service.add(request);
    }
    @PutMapping("/{id}")
    public UpdateModelResponse update(@PathVariable int id, @RequestBody UpdateModelRequest request){
        return service.update(id, request);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        service.delete(id);
    }
}
