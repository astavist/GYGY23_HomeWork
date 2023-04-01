package sametyilmaz.rentacar.api.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sametyilmaz.rentacar.business.abstracts.ModelService;
import sametyilmaz.rentacar.business.dto.requests.create.CreateModelRequest;
import sametyilmaz.rentacar.business.dto.requests.update.UpdateModelRequest;
import sametyilmaz.rentacar.business.dto.responses.create.CreateModelResponse;
import sametyilmaz.rentacar.business.dto.responses.get.GetAllModelResponse;
import sametyilmaz.rentacar.business.dto.responses.get.GetModelResponse;
import sametyilmaz.rentacar.business.dto.responses.update.UpdateModelResponse;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/models")
public class ModelController {
    private final ModelService modelService;

    @GetMapping
    public List<GetAllModelResponse> getAll() {
        return modelService.getAll();
    }
    @GetMapping("{id}")
    public GetModelResponse getById(@PathVariable int id) {
        return modelService.getById(id);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateModelResponse add(@RequestBody CreateModelRequest request) {
        return modelService.add(request);
    }
    @PutMapping("{id}")
    public UpdateModelResponse update(@PathVariable int id, @RequestBody UpdateModelRequest request) {
        return modelService.update(id,request);
    }
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable int id) {
        modelService.delete(id);
    }
}
