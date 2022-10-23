package cl.juan.infrastructure.configuration;

import cl.juan.domain.country.CountryNamesGetterUseCase;
import cl.juan.domain.country.port.CountryNamesGetterPort;
import cl.juan.domain.country.usecase.CountryNamesGetter;

import javax.enterprise.context.ApplicationScoped;

public class UseCaseBeansConfig {

    @ApplicationScoped
    public CountryNamesGetterUseCase countryCodesGetterUseCase(CountryNamesGetterPort countryNamesGetterPort) {
        return new CountryNamesGetter(countryNamesGetterPort);
    }
}
