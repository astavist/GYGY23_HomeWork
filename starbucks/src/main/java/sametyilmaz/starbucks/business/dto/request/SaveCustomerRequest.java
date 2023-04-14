package sametyilmaz.starbucks.business.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SaveCustomerRequest {
    private String firstName;

    private String lastName;

    private String nationalIdentity;

    private int birthYear;
}
