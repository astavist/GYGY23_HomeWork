package sametyilmaz.rentacar.business.dto.requests.create;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sametyilmaz.rentacar.business.dto.requests.PaymentRequest;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreatePaymentRequest extends PaymentRequest {
    @NotNull
    @Min(value = 1)
    private double balance;
}
