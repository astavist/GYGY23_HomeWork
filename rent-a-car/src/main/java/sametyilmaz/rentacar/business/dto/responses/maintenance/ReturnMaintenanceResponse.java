package sametyilmaz.rentacar.business.dto.responses.maintenance;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sametyilmaz.rentacar.entities.enums.State;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReturnMaintenanceResponse {
    private int carId;
    private State state;
}
