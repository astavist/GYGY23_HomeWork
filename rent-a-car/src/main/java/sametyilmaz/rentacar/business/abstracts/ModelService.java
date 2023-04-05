package sametyilmaz.rentacar.business.abstracts;

import sametyilmaz.rentacar.business.dto.requests.create.CreateModelRequest;
import sametyilmaz.rentacar.business.dto.requests.update.UpdateModelRequest;
import sametyilmaz.rentacar.business.dto.responses.create.CreateModelResponse;
import sametyilmaz.rentacar.business.dto.responses.get.model.GetAllModelsResponse;
import sametyilmaz.rentacar.business.dto.responses.get.model.GetModelResponse;
import sametyilmaz.rentacar.business.dto.responses.update.UpdateModelResponse;

import java.util.List;

public interface ModelService {
    List<GetAllModelsResponse> getAll();
    GetModelResponse getById(int id);
    CreateModelResponse add(CreateModelRequest request);
    UpdateModelResponse update(int id, UpdateModelRequest request);
    void delete(int id);
}
