package cl.juan.domain.country;

import io.smallrye.mutiny.Uni;

import java.util.List;

public interface CountryNamesGetterUseCase {
    Uni<List<String>> handle();
}
