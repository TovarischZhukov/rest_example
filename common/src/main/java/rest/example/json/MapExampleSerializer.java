package rest.example.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

@SuppressWarnings("NotNullNullableValidation")
public final class MapExampleSerializer extends StdSerializer<MapExample> {

  public MapExampleSerializer() {
    super(MapExample.class);
  }

  @Override
  public void serialize(MapExample value, JsonGenerator gen, SerializerProvider provider) throws IOException {
    gen.writeStartObject();
    gen.writeNumberField(
        "number",
        value.values().stream().findFirst().map(MapExample.Entry::getId).orElse(1)
    );
    gen.writeEndObject();
  }
}
