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
public class GetAllMaintenanceResponse {
    private int id;
    private Date sendDate;
    private Date returnDate;
    private int carId;

}
