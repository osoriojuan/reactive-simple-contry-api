package cl.juan.domain.country.usecase;

import cl.juan.domain.country.CountryNamesGetterUseCase;
import cl.juan.domain.country.port.CountryNamesGetterPort;
import io.smallrye.mutiny.Uni;

import java.util.List;

public class CountryNamesGetter implements CountryNamesGetterUseCase {
    public final CountryNamesGetterPort countryNamesGetterPort;

    public CountryNamesGetter(CountryNamesGetterPort countryNamesGetterPort) {
        this.countryNamesGetterPort = countryNamesGetterPort;
    }

    @Override
    public Uni<List<String>> handle() {
        return countryNamesGetterPort.getAllCodes();
    }

}
