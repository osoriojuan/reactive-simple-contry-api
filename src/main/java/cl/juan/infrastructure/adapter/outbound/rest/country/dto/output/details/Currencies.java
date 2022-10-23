package cl.juan.infrastructure.adapter.outbound.rest.country.dto.output.details;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class Currencies {
    private final Map<String, SingleCurrency> values = new HashMap<>();

    @JsonAnySetter
    public void setValue(final String property, final SingleCurrency value) {
        values.put(property, value);
    }

    @Setter
    @Getter
    @ToString
    @NoArgsConstructor
    public static class SingleCurrency {
        private String name;
        private String symbol;
    }
}
