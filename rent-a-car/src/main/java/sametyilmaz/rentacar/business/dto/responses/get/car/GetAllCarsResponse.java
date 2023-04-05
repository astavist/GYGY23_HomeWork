package sametyilmaz.rentacar.business.dto.responses.get.car;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sametyilmaz.rentacar.entities.enums.State;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GetAllCarsResponse {
    private int id;
    private int modelYear;
    private String plate;
    private double dailyPrice;
    @Enumerated(EnumType.STRING)
    private State state;
    private int modelId;
}
