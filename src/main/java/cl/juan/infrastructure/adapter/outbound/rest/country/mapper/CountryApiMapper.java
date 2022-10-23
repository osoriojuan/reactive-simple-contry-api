package cl.juan.infrastructure.adapter.outbound.rest.country.mapper;

import cl.juan.domain.country.model.Country;
import cl.juan.domain.country.model.details.Currency;
import cl.juan.infrastructure.adapter.outbound.rest.country.dto.output.CountryDto;
import cl.juan.infrastructure.adapter.outbound.rest.country.dto.output.details.Currencies;
import cl.juan.infrastructure.adapter.outbound.rest.country.dto.output.details.Languages;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface CountryApiMapper {
    CountryApiMapper INSTANCE = Mappers.getMapper(CountryApiMapper.class);

    @Mapping(source = "name.common", target = "commonName")
    @Mapping(source = "name.official", target = "officialName")
    @Mapping(source = "cca3", target = "abbreviation")
    @Mapping(source = "unMember", target = "unitedNationsMember")
    @Mapping(source = "area", target = "areaInKilometers")
    @Mapping(source = "demonyms.eng.f", target = "citizenshipDenomination.female")
    @Mapping(source = "demonyms.eng.m", target = "citizenshipDenomination.male")
    @Mapping(source = "maps.googleMaps", target = "urlMap")
    @Mapping(source = "flags.png", target = "flagUrl")
    @Mapping(source = "subregion", target = "subRegion")
    @Mapping(source = "currencies", target = "currencies")
    @Mapping(source = "startOfWeek", target = "weekStartDay")
    @Mapping(source = "capital", target = "capitalName", qualifiedByName = "firstElementStrings")
    Country dtoToDomain(CountryDto dto);

    default List<String> mapLanguages(Languages value) {
        return new ArrayList<>(value.getValues().values());
    }

    @Named("firstElementStrings")
    default String mapStrings(List<String> value) {
        return (String) getFirstElementOrNull(value);
    }

    default List<Currency> map(Currencies value) {
        if (value == null) return new ArrayList<>();
        if (value.getValues() == null) return new ArrayList<>();
        if (value.getValues().isEmpty()) return new ArrayList<>();

        return value.getValues()
                .entrySet()
                .stream().map(entrySet -> new Currency(entrySet.getKey(), entrySet.getValue().getName()))
                .collect(Collectors.toList());
    }

    private Object getFirstElementOrNull(List<?> values) {
        if (values == null) return null;
        if (values.isEmpty()) return null;
        return values.get(0);
    }

}
