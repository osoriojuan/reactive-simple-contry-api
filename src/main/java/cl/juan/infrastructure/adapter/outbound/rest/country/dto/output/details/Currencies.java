package cl.juan.infrastructure.adapter.outbound.rest.country.dto.output.details;

import cl.juan.domain.country.model.details.Currency;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Map;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class Currencies {
    //TODO:  map this variable key
    private Map<String, List<Currency>> currency;
}
