package sametyilmaz.rentacar.business.dto.responses.get;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GetMaintenanceResponse {
    private int id;
    private int carId;
    private Date sendDate;
    private Date returnDate;
}
