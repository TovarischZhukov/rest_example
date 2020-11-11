package rest.example.api;

import rest.example.json.JsonExample;

import javax.ws.rs.*;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;

@SuppressWarnings("NotNullNullableValidation")
@Path("/json")
public final class JsonREST {

  @Path("/post")
  @POST
  @Produces(MediaType.TEXT_PLAIN)
  @Consumes(MediaType.APPLICATION_JSON)
  public String post(JsonExample jsonExample) {
    return "Data - " + jsonExample.data + ", values - " + jsonExample.values.toString();
  }

  @Path("/get")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response get() {
    return Response.ok(
        new JsonExample("something", Arrays.asList(1, 2, 3))
    ).header(HttpHeaders.CACHE_CONTROL, "no-cache").build();
  }
}
