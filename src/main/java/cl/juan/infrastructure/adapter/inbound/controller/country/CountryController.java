package cl.juan.infrastructure.adapter.inbound.controller.country;

import cl.juan.domain.country.CountryCodesGetterUseCase;
import io.quarkus.logging.Log;
import io.smallrye.mutiny.Uni;
import org.jboss.resteasy.reactive.RestResponse;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/hello")
@ApplicationScoped
public class CountryController {

    private final CountryCodesGetterUseCase countryCodesGetterUseCase;

    CountryController(CountryCodesGetterUseCase countryCodesGetterUseCase) {
        this.countryCodesGetterUseCase = countryCodesGetterUseCase;
    }

    @GET
    @Path("say-something")
    @Produces(MediaType.APPLICATION_JSON)
    public String hello(@QueryParam("thingToSay") @DefaultValue("NONE") String thingToSay) {
        Log.info(String.format("I have something to say... [%s]", thingToSay));
        return thingToSay;
    }

    @GET
    @Path("codes")
    public Uni<RestResponse<List<String>>> getAllCodes() {
        Log.info("Getting available country codes...");

        return countryCodesGetterUseCase.handle().map(strings -> {
            return RestResponse.ResponseBuilder.ok(strings)
                    .header("TEST-HEADER", "header")
                    .build();
        });
    }
}