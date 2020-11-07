package rest.example.server;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import java.io.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Map;

@SuppressWarnings("NotNullNullableValidation")
@Provider
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public final class JacksonMessageBodyHandler<T> implements MessageBodyReader<T>, MessageBodyWriter<T> {
  private static final String PRETTY_PRINT_PARAMETER_NAME = "pretty";
  private final ObjectMapper objectMapper = new ObjectMapper();
  private final ObjectMapper prettyObjectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
  @SuppressWarnings("unused")
  @Context
  private UriInfo ui;

  public JacksonMessageBodyHandler() {
    this(Collections.emptyMap());
  }

  public JacksonMessageBodyHandler(Map<Class<?>, Class<?>> mixins) {
    mixins.forEach((k, v) -> {
      objectMapper.addMixIn(k, v);
      prettyObjectMapper.addMixIn(k, v);
    });
  }

  @Override
  public boolean isReadable(Class<?> type,
                            Type genericType,
                            Annotation[] annotations,
                            MediaType mediaType) {
    return true;
  }

  @Override
  public T readFrom(Class<T> type,
                    Type genericType,
                    Annotation[] annotations,
                    MediaType mediaType,
                    MultivaluedMap<String, String> httpHeaders,
                    InputStream entityStream) throws IOException, WebApplicationException {
    try (final InputStreamReader reader = new InputStreamReader(entityStream, StandardCharsets.UTF_8.name())) {
      return objectMapper.readValue(reader, type);
    }
  }

  @Override
  public boolean isWriteable(Class<?> type,
                             Type genericType,
                             Annotation[] annotations,
                             MediaType mediaType) {
    return true;
  }

  @Override
  public long getSize(T t,
                      Class<?> type,
                      Type genericType,
                      Annotation[] annotations,
                      MediaType mediaType) {
    return -1;
  }

  @Override
  public void writeTo(T t,
                      Class<?> type,
                      Type genericType,
                      Annotation[] annotations,
                      MediaType mediaType,
                      MultivaluedMap<String, Object> httpHeaders,
                      OutputStream entityStream) throws WebApplicationException {
    try (final PrintWriter printWriter =
             new PrintWriter(new OutputStreamWriter(entityStream, StandardCharsets.UTF_8), true)) {
      final String json = ui.getQueryParameters().containsKey(PRETTY_PRINT_PARAMETER_NAME)
          ? prettyObjectMapper.writeValueAsString(t)
          : objectMapper.writeValueAsString(t);
      printWriter.write(json);
    } catch (JsonProcessingException e) {
      throw new WebApplicationException(e);
    }
  }
}
