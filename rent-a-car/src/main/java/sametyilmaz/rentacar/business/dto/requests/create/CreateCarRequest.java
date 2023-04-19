package sametyilmaz.rentacar.business.dto.requests.create;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sametyilmaz.rentacar.common.constants.Regex;
import sametyilmaz.rentacar.common.utils.annotations.NotFutureYear;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CreateCarRequest {
    private int modelId;
    @Min(value = 1)
    private double dailyPrice;
    @Min(value = 1998)
    @NotFutureYear
    private int modelYear;
    @Pattern(regexp = Regex.plate, message = "Plate pattern is not correct")
    private String plate;
}
