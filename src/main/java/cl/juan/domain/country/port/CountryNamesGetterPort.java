package cl.juan.domain.country.port;

import io.smallrye.mutiny.Uni;

import java.util.List;

public interface CountryNamesGetterPort {
    Uni<List<String>> getAllCodes();
}
