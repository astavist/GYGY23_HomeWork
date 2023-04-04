package sametyilmaz.rentacar.business.dto.responses.update;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UpdateModelResponse {
    private int id;
    private String name;
    private int brandId;
}
