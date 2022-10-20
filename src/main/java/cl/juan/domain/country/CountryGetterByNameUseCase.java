package cl.juan.domain.country;

import cl.juan.domain.country.model.Country;

public interface CountryGetterByNameUseCase {
    Country handle(String name);
}
