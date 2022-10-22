package cl.juan.infrastructure.adapter.outbound.rest.country.dto.output.details;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class Flags {
    private String png;
    private String svg;
}
