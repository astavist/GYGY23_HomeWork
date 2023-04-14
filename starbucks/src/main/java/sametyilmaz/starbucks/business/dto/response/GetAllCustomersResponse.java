package sametyilmaz.starbucks.business.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetAllCustomersResponse {
    private int id;

    private String firstName;

    private String lastName;

    private String nationalIdentity;

    private int birthYear;
}
