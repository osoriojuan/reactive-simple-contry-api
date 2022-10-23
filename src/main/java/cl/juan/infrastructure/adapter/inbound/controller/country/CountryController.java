package cl.juan.infrastructure.adapter.inbound.controller.country;

import cl.juan.domain.country.CountryNamesGetterUseCase;
import cl.juan.domain.country.model.Country;
import cl.juan.infrastructure.adapter.outbound.rest.country.CountryClientResolver;
import io.quarkus.logging.Log;
import io.smallrye.mutiny.Uni;
import org.jboss.resteasy.reactive.RestResponse;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Path("/country")
@ApplicationScoped
public class CountryController {

    //https://restcountries.com/#api-endpoints-v3-code

    private final CountryNamesGetterUseCase countryCodesGetterUseCase;
    private final CountryClientResolver countryClientResolver;

    CountryController(CountryNamesGetterUseCase countryCodesGetterUseCase,
                      CountryClientResolver countryClientResolver) {
        this.countryCodesGetterUseCase = countryCodesGetterUseCase;
        this.countryClientResolver = countryClientResolver;
    }

    @GET
    @Path("say-something")
    @Produces(MediaType.APPLICATION_JSON)
    public String hello(@QueryParam("thingToSay") @DefaultValue("NONE") String thingToSay) {
        Log.info(String.format("I have something to say... [%s]", thingToSay));
        return thingToSay;
    }

    @GET
    @Path("get-by-name")
    public Uni<RestResponse<Country>> getByName(@QueryParam("name") @DefaultValue("") String name) throws ExecutionException, InterruptedException {
        Log.info("Getting country by name controller...");
        return countryClientResolver.getFirstCountryByName(name)
                .map(domain -> RestResponse.ResponseBuilder.ok(domain)
                        .build());
    }

    @GET
    @Path("get-all-names")
    public Uni<List<String>> getAllNames() {
        return countryCodesGetterUseCase.handle();
    }
}