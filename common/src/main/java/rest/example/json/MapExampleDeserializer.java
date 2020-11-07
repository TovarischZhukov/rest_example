package rest.example.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

@SuppressWarnings("NotNullNullableValidation")
public final class MapExampleDeserializer extends StdDeserializer<MapExample> {
  protected MapExampleDeserializer() {
    super(MapExample.class);
  }

  @Override
  public MapExample deserialize(JsonParser parser, DeserializationContext context) {
    return new MapExample();
  }
}
