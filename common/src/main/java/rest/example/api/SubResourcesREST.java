package rest.example.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@SuppressWarnings("NotNullNullableValidation")
@Path("/root")
public final class SubResourcesREST {

  @GET
  @Path("/first")
  public String first() {
    return "Hello first!";
  }

  @GET
  @Path("/second")
  public String second() {
    return "Hello second!";
  }
}
