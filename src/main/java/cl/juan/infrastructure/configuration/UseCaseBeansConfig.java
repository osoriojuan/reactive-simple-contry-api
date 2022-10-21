package cl.juan.infrastructure.configuration;

import cl.juan.domain.country.CountryCodesGetterUseCase;
import cl.juan.domain.country.usecase.CountryCodesGetter;

import javax.enterprise.context.ApplicationScoped;

public class UseCaseBeansConfig {

    @ApplicationScoped
    public CountryCodesGetterUseCase countryCodesGetterUseCase() {
        return new CountryCodesGetter();
    }
}
