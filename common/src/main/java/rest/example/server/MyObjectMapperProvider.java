package rest.example.server;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;


@SuppressWarnings("NotNullNullableValidation")
@Provider
public final class MyObjectMapperProvider implements ContextResolver<ObjectMapper> {
  final ObjectMapper defaultObjectMapper;

  public MyObjectMapperProvider() {
    final ObjectMapper result = new ObjectMapper();
    result.configure(SerializationFeature.INDENT_OUTPUT, true);
    defaultObjectMapper = result;
  }

  @Override
  public ObjectMapper getContext(Class<?> type) {
    return defaultObjectMapper;
  }
}
