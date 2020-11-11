package rest.example.json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@SuppressWarnings("NotNullNullableValidation")
@JsonIgnoreProperties(ignoreUnknown = true)
public final class JsonExample {
  @JsonProperty("data")
  public final String data;
  @JsonProperty("valueNames")
  public final List<Integer> values;

  @JsonCreator
  public JsonExample(@JsonProperty(value = "data", required = true) String data,
                     @JsonProperty("valueNames") List<Integer> values) {
    this.data = data;
    this.values = values;
  }
}
