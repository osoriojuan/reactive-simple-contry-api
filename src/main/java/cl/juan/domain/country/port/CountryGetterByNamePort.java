package cl.juan.domain.country.port;

import cl.juan.domain.country.model.Country;
import io.smallrye.mutiny.Uni;

public interface CountryGetterByNamePort {
    Uni<Country> getFirstCountryByName(String name);
}
