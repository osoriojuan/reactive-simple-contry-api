package cl.juan.infrastructure.adapter.outbound.rest.country.dto.output.details;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class Car {
    private ArrayList<String> signs;
    private String side;
}
