package rest.example.json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

@SuppressWarnings("NotNullNullableValidation")
@JsonIgnoreProperties(ignoreUnknown = true)
public final class Example {
  public final String data;
  public final List<Integer> values;

  public static void main(String[] args) throws IOException {
    final ObjectMapper objectMapper = new ObjectMapper();
    final Example example = objectMapper.readValue(
        "{" +
            "\"data\": \"something\", " +
            "\"values\": [5, 4, 3, 2, 1]" +
            "}", Example.class);
    final String s = objectMapper.writeValueAsString(example);
    System.out.println(s);
  }

  @JsonCreator
  public Example(@JsonProperty("data") String data,
                 @JsonProperty("values") List<Integer> values) {
    this.data = data;
    this.values = values;
  }
}
