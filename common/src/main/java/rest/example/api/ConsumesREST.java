package rest.example.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@SuppressWarnings("NotNullNullableValidation")
@Path("/consumes")
public final class ConsumesREST {
  @POST
  @Consumes(MediaType.TEXT_PLAIN)
  public String get(String message) {
    return content(message);
  }

  private String content(String message) {
    return "<!DOCTYPE html>" +
        "<html>" +
        "<head><title>Example</title></head>" +
        "<body><h1>" + message + "</h1></body>" +
        "</html>";
  }
}
