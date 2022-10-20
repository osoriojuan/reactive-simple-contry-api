package cl.juan.domain.country.usecase;

import cl.juan.domain.country.CountryCodesGetterUseCase;
import io.smallrye.mutiny.Uni;

import java.util.List;

public class CountryCodesGetter implements CountryCodesGetterUseCase {

    @Override
    public Uni<List<String>> handle() {
        return Uni.createFrom()
                .item(List.of("HELLO", "THIS", "IS", "A", "TEST"));
    }

}
