package sametyilmaz.starbucks.business.configuration.mernis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sametyilmaz.starbucks.adapters.mernis.HSTKPSPublicSoap;

@Configuration
public class MernisConfig {
    @Bean
    public HSTKPSPublicSoap getMernis(){
        return new HSTKPSPublicSoap();
    }
}
