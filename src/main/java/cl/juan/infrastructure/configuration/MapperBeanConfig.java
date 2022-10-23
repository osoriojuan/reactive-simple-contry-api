package cl.juan.infrastructure.configuration;

import cl.juan.infrastructure.adapter.outbound.rest.country.mapper.CountryApiMapper;

import javax.enterprise.context.ApplicationScoped;

public class MapperBeanConfig {

    @ApplicationScoped
    public CountryApiMapper countryMapper() {
        return CountryApiMapper.INSTANCE;
    }

}
