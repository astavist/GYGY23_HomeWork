package sametyilmaz.rentacar.business.concrete;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import sametyilmaz.rentacar.business.abstracts.ModelService;
import sametyilmaz.rentacar.business.dto.requests.create.CreateModelRequest;
import sametyilmaz.rentacar.business.dto.requests.update.UpdateModelRequest;
import sametyilmaz.rentacar.business.dto.responses.create.CreateModelResponse;
import sametyilmaz.rentacar.business.dto.responses.get.model.GetAllModelsResponse;
import sametyilmaz.rentacar.business.dto.responses.get.model.GetModelResponse;
import sametyilmaz.rentacar.business.dto.responses.update.UpdateModelResponse;
import sametyilmaz.rentacar.business.rules.ModelBusinessRules;
import sametyilmaz.rentacar.entities.Model;
import sametyilmaz.rentacar.repository.ModelRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class ModelManager implements ModelService {
    private final ModelRepository repository;
    private final ModelMapper mapper;
    private final ModelBusinessRules rules;

    @Override
    public List<GetAllModelsResponse> getAll() {
        List<Model> models = repository.findAll();
        List<GetAllModelsResponse> response = models.stream()
                .map(model -> mapper.map(model, GetAllModelsResponse.class)).toList();
        return response;
    }

    @Override
    public GetModelResponse getById(int id) {
        rules.checkIfModelExists(id);

        return mapper.map(repository.findById(id),GetModelResponse.class);
    }

    @Override
    public CreateModelResponse add(CreateModelRequest request) {
        Model model = mapper.map(request, Model.class);
        model.setId(0);
        repository.save(model);
        return mapper.map(model,CreateModelResponse.class);
    }

    @Override
    public UpdateModelResponse update(int id, UpdateModelRequest request) {
        rules.checkIfModelExists(id);

        Model model = mapper.map(request,Model.class);
        model.setId(id);
        repository.save(model);

        UpdateModelResponse response = mapper.map(model,UpdateModelResponse.class);
        return response;
    }

    @Override
    public void delete(int id) {
        rules.checkIfModelExists(id);

        repository.deleteById(id);
    }
}
