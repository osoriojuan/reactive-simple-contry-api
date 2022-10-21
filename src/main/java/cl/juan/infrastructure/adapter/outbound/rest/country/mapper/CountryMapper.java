package cl.juan.infrastructure.adapter.outbound.rest.country.mapper;

import cl.juan.domain.country.model.Country;
import cl.juan.infrastructure.adapter.outbound.rest.country.dto.output.CountryDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CountryMapper {
    CountryMapper INSTANCE = Mappers.getMapper(CountryMapper.class);


    Country dtoToDomain(CountryDto dto);
}
