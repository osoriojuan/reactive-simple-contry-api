package cl.juan.infrastructure.adapter.outbound.rest.country;

import cl.juan.domain.country.port.CountryCodesGetterPort;
import cl.juan.domain.country.port.CountryGetterByNamePort;
import cl.juan.infrastructure.adapter.outbound.rest.country.client.CountryClient;
import cl.juan.infrastructure.adapter.outbound.rest.country.dto.output.CountryDto;
import io.quarkus.logging.Log;
import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;


@ApplicationScoped
public class CountryClientResolver implements CountryCodesGetterPort, CountryGetterByNamePort {

    @RestClient
    CountryClient countryClient;

    @Override
    public List<String> getAllCodes() {
        return null;
    }

    @Override
    public Uni<List<CountryDto>> getFirstCountryByName(String name) {
        Log.info("Getting countryByName");
        return countryClient.getCountriesByName(name);
    }

}
