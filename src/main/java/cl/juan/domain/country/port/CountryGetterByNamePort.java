package cl.juan.domain.country.port;

import cl.juan.domain.country.model.Country;
import cl.juan.infrastructure.adapter.outbound.rest.country.dto.output.CountryDto;
import io.smallrye.mutiny.Uni;

import java.util.List;

public interface CountryGetterByNamePort {
    Uni<List<CountryDto>> getCountryByName(String name);
}
