package rest.example.server;

import java.time.Instant;
import java.util.Date;

@SuppressWarnings("NotNullNullableValidation")
public final class ContentGenerator {

  public String content() {
    return "<!DOCTYPE html>" +
        "<html>" +
        "<head><title>Example</title></head>" +
        "<body><h1>" + "Current time " + Date.from(Instant.now()) + "</h1></body>" +
        "</html>";
  }
}
