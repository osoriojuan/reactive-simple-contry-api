package cl.juan.infrastructure.adapter.outbound.rest.country;

import cl.juan.domain.country.model.Country;
import cl.juan.domain.country.port.CountryGetterByNamePort;
import cl.juan.domain.country.port.CountryNamesGetterPort;
import cl.juan.infrastructure.adapter.outbound.rest.country.client.CountryClient;
import cl.juan.infrastructure.adapter.outbound.rest.country.dto.output.CountryDto;
import cl.juan.infrastructure.adapter.outbound.rest.country.mapper.CountryApiMapper;
import io.quarkus.logging.Log;
import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.NotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@ApplicationScoped
public class CountryClientResolver implements CountryNamesGetterPort, CountryGetterByNamePort {

    private final CountryClient countryClient;

    private final CountryApiMapper countryMapper;

    CountryClientResolver(@RestClient CountryClient countryClient,
                          CountryApiMapper countryMapper) {
        this.countryClient = countryClient;
        this.countryMapper = countryMapper;
    }

    @Override
    public Uni<List<String>> getAllCodes() {
        return countryClient.getAllCountries()
                .map(countryDtos -> countryDtos.stream()
                        .map(dto -> dto.getName().getCommon())
                        .collect(Collectors.toList()));
    }

    @Override
    public Uni<Country> getFirstCountryByName(String name) {
        Log.info("Getting countryByName");
        return countryClient.getCountriesByName(name)
                .map(countryDtos -> countryDtos.stream().findFirst().orElseThrow(NotFoundException::new))
                .flatMap(this::mutateDtoToReplaceBorderCodesWithReadableNames)
                .map(countryMapper::dtoToDomain);
    }

    private Uni<CountryDto> mutateDtoToReplaceBorderCodesWithReadableNames(CountryDto dto) {
        var borderCountryNamesUni = getCountryNamesByShortNames(Optional.ofNullable(dto.getBorders())
                .orElse(new ArrayList<>()));
        return borderCountryNamesUni.map(borderCountryNames -> {
            dto.setBorders(borderCountryNames);
            return dto;
        });
    }

    private Uni<List<String>> getCountryNamesByShortNames(List<String> shortNames) {
        var codesSeparatedByComma = String.join(",", shortNames);
        Log.info("Doing request with codesSeparatedByComma = " + codesSeparatedByComma);
        return shortNames.size() >= 1 ? countryClient.getCountriesByCodesSeparatedByComma(codesSeparatedByComma)
                .map(countryDtos -> countryDtos.stream()
                        .map(dto -> dto.getName().getCommon())
                        .collect(Collectors.toList())
                ) : Uni.createFrom().item(shortNames);
    }

}
