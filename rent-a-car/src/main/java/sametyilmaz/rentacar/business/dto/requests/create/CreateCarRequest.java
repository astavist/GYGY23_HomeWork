package sametyilmaz.rentacar.business.dto.requests.create;

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
public class CreateCarRequest {
    private int modelYear;
    private String plate;
    private double dailyPrice;
    @Enumerated(EnumType.STRING)
    private State state;
    private int modelId;
}
