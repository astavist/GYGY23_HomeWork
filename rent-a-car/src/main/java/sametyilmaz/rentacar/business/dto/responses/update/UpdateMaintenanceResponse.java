package sametyilmaz.rentacar.business.dto.responses.update;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UpdateMaintenanceResponse {
    private int id;
    private Date sendDate;
    private Date returnDate;
    private int carId;
}
