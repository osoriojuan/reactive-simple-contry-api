package cl.juan.domain.country.model;

import cl.juan.domain.country.model.details.CitizenshipDenomination;
import cl.juan.domain.country.model.details.Currency;
import lombok.Value;

import java.util.List;

@Value
public class Country {
    String commonName;
    String officialName;
    String abbreviation;
    boolean independent;
    boolean unitedNationsMember;
    List<Currency> currencies;
    String capitalName;
    String region;
    String subRegion;
    List<String> languages;
    boolean landlocked;
    List<Country> borders;
    long areaInKilometers;
    CitizenshipDenomination citizenshipDenomination;
    String urlMap;
    int population;
    List<String> timezones;
    List<String> continents;
    String flagUrl;
}
