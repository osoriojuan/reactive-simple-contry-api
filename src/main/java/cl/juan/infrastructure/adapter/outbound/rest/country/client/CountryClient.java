package cl.juan.infrastructure.adapter.outbound.rest.country.client;

import cl.juan.domain.country.model.Country;
import cl.juan.infrastructure.adapter.outbound.rest.country.dto.output.CountryDto;
import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;

@Path("/v3.1")
@RegisterRestClient(configKey = "countries-api")
public interface CountryClient {

    @GET
    @Path("name/{name}")
    Uni<List<CountryDto>> getByName(@PathParam("name") String name);
}
