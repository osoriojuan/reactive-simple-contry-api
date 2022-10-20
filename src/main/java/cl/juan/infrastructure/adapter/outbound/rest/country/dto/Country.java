package cl.juan.infrastructure.adapter.outbound.rest.country.dto;

import java.util.ArrayList;

// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */

public class Country{
    public Name name;
    public ArrayList<String> tld;
    public String cca2;
    public String ccn3;
    public String cca3;
    public String cioc;
    public boolean independent;
    public String status;
    public boolean unMember;
    public Currencies currencies;
    public Idd idd;
    public ArrayList<String> capital;
    public ArrayList<String> altSpellings;
    public String region;
    public String subregion;
    public Languages languages;
    public ArrayList<Double> latlng;
    public boolean landlocked;
    public ArrayList<String> borders;
    public double area;
    public Demonyms demonyms;
    public String flag;
    public Maps maps;
    public int population;
    public String fifa;
    public Car car;
    public ArrayList<String> timezones;
    public ArrayList<String> continents;
    public Flags flags;
    public CoatOfArms coatOfArms;
    public String startOfWeek;
    public CapitalInfo capitalInfo;
    public PostalCode postalCode;
}
