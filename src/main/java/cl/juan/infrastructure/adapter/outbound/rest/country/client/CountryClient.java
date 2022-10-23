package cl.juan.infrastructure.adapter.outbound.rest.country.client;

import cl.juan.infrastructure.adapter.outbound.rest.country.dto.output.CountryDto;
import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import java.util.Set;

@Path("/v3.1")
@RegisterRestClient(configKey = "countries-api")
public interface CountryClient {
    @GET
    @Path("name/{name}")
    Uni<Set<CountryDto>> getCountriesByName(@PathParam("name") String name);

    @GET
    @Path("alpha")
    Uni<Set<CountryDto>> getCountriesByCodesSeparatedByComma(@QueryParam("codes") String codesSeparatedByComma);

    @GET
    @Path("all")
    Uni<Set<CountryDto>> getAllCountries();
}
