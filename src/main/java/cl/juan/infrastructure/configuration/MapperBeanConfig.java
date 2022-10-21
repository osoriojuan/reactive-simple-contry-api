package cl.juan.infrastructure.configuration;

import cl.juan.infrastructure.adapter.outbound.rest.country.mapper.CountryMapper;

import javax.enterprise.context.ApplicationScoped;

public class MapperBeanConfig {

    @ApplicationScoped
    public CountryMapper countryMapper() {
        return CountryMapper.INSTANCE;
    }

}
