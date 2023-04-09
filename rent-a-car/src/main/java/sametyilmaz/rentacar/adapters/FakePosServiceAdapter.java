package sametyilmaz.rentacar.adapters;

import org.springframework.stereotype.Service;
import sametyilmaz.rentacar.business.abstracts.PosService;

import java.util.Random;

@Service
public class FakePosServiceAdapter implements PosService {
//    3dsecure ödeme servisini taklit eden program
    @Override
    public void pay() {
        boolean isPaymentSuccessful = new Random().nextBoolean();
        if (!isPaymentSuccessful) {
            throw new RuntimeException("Ödeme Reddedildi");
        }
    }
}
