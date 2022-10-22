package cl.juan.infrastructure.adapter.outbound.rest.country.dto.output;

import cl.juan.infrastructure.adapter.outbound.rest.country.dto.output.details.*;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.*;

import java.util.ArrayList;

@Setter
@Getter
@ToString
@Builder
public class CountryDto {
    private Name name;
    private ArrayList<String> tld;
    private String cca2;
    private String ccn3;
    private String cca3;
    private String cioc;
    private boolean independent;
    private String status;
    private boolean unMember;
    private Currencies currencies;
    private Idd idd;
    private ArrayList<String> capital;
    private ArrayList<String> altSpellings;
    private String region;
    private String subregion;
    private Languages languages;
    private ArrayList<Double> latlng;
    private boolean landlocked;
    private ArrayList<String> borders;
    private double area;
    private Demonyms demonyms;
    private String flag;
    private Maps maps;
    private int population;
    private String fifa;
    private Car car;
    private ArrayList<String> timezones;
    private ArrayList<String> continents;
    private Flags flags;
    private CoatOfArms coatOfArms;
    private String startOfWeek;
    private CapitalInfo capitalInfo;
    private PostalCode postalCode;

}
