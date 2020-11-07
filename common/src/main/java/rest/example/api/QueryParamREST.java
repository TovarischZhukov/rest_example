package rest.example.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@SuppressWarnings("NotNullNullableValidation")
@Path("/query/param")
public final class QueryParamREST {

  @GET
  public String get(@QueryParam("name") String name,
                    @QueryParam("age") Integer age) {
    return "Name - " + name + ", age - " + age;
  }
}
