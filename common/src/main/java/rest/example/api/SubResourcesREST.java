package rest.example.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@SuppressWarnings("NotNullNullableValidation")
@Path("/root")
public final class SubResourcesREST {

  @GET
  public String root() {
    return "Hello first root!";
  }

  @GET
  @Path("/path1")
  public String first() {
    return "Hello first path1!";
  }

  @Path("/second")
  public SecondResource second() {
    return new SecondResource();
  }

  public static final class SecondResource {

    @GET
    public String root() {
      return "Hello second root!";
    }

    @GET
    @Path("/path1")
    public String first() {
      return "Hello second path1!";
    }
  }
}
