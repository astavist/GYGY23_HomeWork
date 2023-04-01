package sametyilmaz.rentacar.business.dto.requests.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sametyilmaz.rentacar.entities.enums.State;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CreateCarRequest {
    private int modelYear;
    private String plate;
    private double dailyPrice;
    private State state;
    private int modelId;
}
