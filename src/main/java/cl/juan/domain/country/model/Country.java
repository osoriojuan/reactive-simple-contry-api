package cl.juan.domain.country.model;

import cl.juan.domain.country.model.details.CitizenshipDenomination;
import cl.juan.domain.country.model.details.Currency;

import java.util.List;

public class Country {
    private String commonName;
    private String officialName;
    private String abbreviation;
    private boolean independent;
    private boolean unitedNationsMember;
    private List<Currency> currencies;
    private String capitalName;
    private String region;
    private String subRegion;
    private List<String> languages;
    private boolean landlocked;
    private List<Country> borders;
    private long areaInKilometers;
    private CitizenshipDenomination citizenshipDenomination;
    private String urlMap;
    private int population;
    private List<String> timezones;
    private List<String> continents;
    private String flagUrl;
}
