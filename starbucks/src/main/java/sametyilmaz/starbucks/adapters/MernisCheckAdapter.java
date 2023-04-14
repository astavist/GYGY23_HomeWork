package sametyilmaz.starbucks.adapters;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sametyilmaz.starbucks.adapters.mernis.HSTKPSPublicSoap;
import sametyilmaz.starbucks.business.dto.request.SaveCustomerRequest;


@Service
@AllArgsConstructor
public class MernisCheckAdapter {
    private HSTKPSPublicSoap mernis;

    public boolean checkPersonIsReal(SaveCustomerRequest request) throws Exception{
        return mernis.TCKimlikNoDogrula(Long.parseLong(request.getNationalIdentity())
                ,request.getFirstName().toUpperCase()
                ,request.getLastName().toUpperCase()
                ,request.getBirthYear());
    }


}
