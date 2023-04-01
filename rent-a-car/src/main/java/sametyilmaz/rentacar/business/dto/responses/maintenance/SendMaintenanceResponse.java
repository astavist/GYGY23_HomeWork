package sametyilmaz.rentacar.business.dto.responses.maintenance;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sametyilmaz.rentacar.entities.enums.State;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SendMaintenanceResponse {
    private int carId;
    private State state;
}
