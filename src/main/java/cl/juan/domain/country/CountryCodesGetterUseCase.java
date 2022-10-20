package cl.juan.domain.country;

import io.smallrye.mutiny.Uni;

import java.util.List;

public interface CountryCodesGetterUseCase {
    Uni<List<String>> handle();
}
