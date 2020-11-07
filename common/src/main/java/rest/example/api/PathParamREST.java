package rest.example.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@SuppressWarnings("NotNullNullableValidation")
@Path("/path/param/{name}")
public final class PathParamREST {

  @GET
  public String get(@PathParam("name") String name) {
    return "Hello " + name + '!';
  }
}
