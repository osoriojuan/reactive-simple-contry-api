package cl.juan.infrastructure.adapter.outbound.rest.country.dto.output.details;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@RegisterForReflection
public class Currencies {
    @JsonProperty("CLP")
    private CLP cLP;
}
