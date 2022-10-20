package cl.juan;

import io.quarkus.logging.Log;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @GET
    @Path("say-something")
    @Produces(MediaType.APPLICATION_JSON)
    public String hello(@QueryParam("thingToSay") @DefaultValue("NONE") String thingToSay) {
        Log.info(String.format("I have something to say... [%s]", thingToSay));
        return thingToSay;
    }
}