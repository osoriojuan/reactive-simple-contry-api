package cl.juan.infrastructure.adapter.outbound.rest.country.dto.output;

import cl.juan.infrastructure.adapter.outbound.rest.country.dto.output.details.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
@Builder
public class CountryDto {
    private Name name;
    private List<String> tld;
    private String cca2;
    private String ccn3;
    private String cca3;
    private String cioc;
    private boolean independent;
    private String status;
    private boolean unMember;
    private Currencies currencies;
    private Idd idd;
    private List<String> capital;
    private List<String> altSpellings;
    private String region;
    private String subregion;
    private Languages languages;
    private List<Double> latlng;
    private boolean landlocked;
    private List<String> borders;
    private long area;
    private Demonyms demonyms;
    private String flag;
    private Maps maps;
    private int population;
    private String fifa;
    private Car car;
    private List<String> timezones;
    private List<String> continents;
    private Flags flags;
    private CoatOfArms coatOfArms;
    private String startOfWeek;
    private CapitalInfo capitalInfo;
    private PostalCode postalCode;



}
