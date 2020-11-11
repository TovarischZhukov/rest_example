package rest.example;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import rest.example.json.JsonExample;

import java.io.IOException;

@SuppressWarnings("NotNullNullableValidation")
@JsonIgnoreProperties(ignoreUnknown = true)
public final class ExampleJakson {
  public static void main(String[] args) throws IOException {
    final ObjectMapper objectMapper = new ObjectMapper();
    final JsonExample jsonExample = objectMapper.readValue(
        "{" +
            "\"data\": \"something\", " +
            "\"values\": [5, 4, 3, 2, 1]" +
            "}", JsonExample.class);
    final String s = objectMapper.writeValueAsString(jsonExample);
    System.out.println(s);
  }
}
