package cl.juan.domain.country;

import cl.juan.domain.country.model.Country;

import java.util.List;

public interface CountryGetterAllUseCase {
    List<Country> handle();
}
