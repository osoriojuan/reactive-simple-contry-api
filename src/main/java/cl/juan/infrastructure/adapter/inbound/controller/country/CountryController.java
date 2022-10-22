package cl.juan.infrastructure.adapter.inbound.controller.country;

import cl.juan.domain.country.CountryCodesGetterUseCase;
import cl.juan.infrastructure.adapter.outbound.rest.country.CountryClientResolver;
import cl.juan.infrastructure.adapter.outbound.rest.country.dto.output.CountryDto;
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

    private final CountryCodesGetterUseCase countryCodesGetterUseCase;
    private final CountryClientResolver countryClientResolver;

    CountryController(CountryCodesGetterUseCase countryCodesGetterUseCase,
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
    public Uni<RestResponse<List<CountryDto>>> getByName(@QueryParam("name") @DefaultValue("") String name) throws ExecutionException, InterruptedException {
        Log.info("Getting country by name controller...");
        return countryClientResolver.getFirstCountryByName(name)
                .map(dto -> RestResponse.ResponseBuilder.ok(dto)
                        .build());

    }
}