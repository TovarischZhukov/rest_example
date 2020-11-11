package rest.example.api;

import rest.example.server.ContentGenerator;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@SuppressWarnings("NotNullNullableValidation")
@Path("/time")
public final class PathREST {

  @GET
  public String get() {
    return new ContentGenerator().content();
  }
}
