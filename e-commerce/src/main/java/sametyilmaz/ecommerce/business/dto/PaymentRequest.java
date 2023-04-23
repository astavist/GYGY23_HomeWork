package sametyilmaz.ecommerce.business.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentRequest {
    @Length(min = 3)
    @NotBlank
    private String customerName;
    @NotBlank
    @Length(min = 16,max = 16)
    private String cardNumber;
    @Min(2023)
    @NotNull
    private int cardExpirationYear;
    @Min(0)
    @Max(12)
    @NotNull
    private int cardExpirationMonth;
    @Min(99)
    @Max(999)
    @NotNull
    private int cardCvv;
}
