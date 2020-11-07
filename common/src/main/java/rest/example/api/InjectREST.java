package rest.example.api;

import rest.example.server.ContentGenerator;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;


@SuppressWarnings("NotNullNullableValidation")
@Path("/inject")
public final class InjectREST {
  private final ContentGenerator contentGenerator;

  @Inject
  public InjectREST(ContentGenerator contentGenerator) {
    this.contentGenerator = contentGenerator;
  }

  @GET
  public Response get() {
    return Response.ok(contentGenerator.content()).header(HttpHeaders.CACHE_CONTROL, "no-cache").build();
  }
}
