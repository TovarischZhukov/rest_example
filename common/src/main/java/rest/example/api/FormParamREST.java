package rest.example.api;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.Collections;
import java.util.List;

@SuppressWarnings("NotNullNullableValidation")
@Path("/form/param")
public final class FormParamREST {

  @POST
  public String get(@FormParam("numbers") List<Integer> numbers) {
    return "Numbers - " + numbers.toString();
  }

  @GET
  public String get() {
    return "Numbers - " + Collections.singletonList(1).toString();
  }
}
