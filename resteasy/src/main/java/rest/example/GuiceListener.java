package rest.example;

import com.google.inject.AbstractModule;
import com.google.inject.Module;
import org.jboss.resteasy.plugins.guice.GuiceResteasyBootstrapServletContextListener;
import rest.example.api.*;
import rest.example.server.JacksonMessageBodyHandler;

import javax.servlet.ServletContext;
import java.util.Collections;
import java.util.List;

@SuppressWarnings("NotNullNullableValidation")
public final class GuiceListener extends GuiceResteasyBootstrapServletContextListener {

  @Override
  protected List<? extends Module> getModules(ServletContext context) {
    return Collections.singletonList(new GuiceModule());
  }

  @SuppressWarnings("rawtypes")
  private static final class GuiceModule extends AbstractModule {
    @SuppressWarnings("PointlessBinding")
    @Override
    protected void configure() {
      bind(JacksonMessageBodyHandler.class).toInstance(new JacksonMessageBodyHandler());
      bind(InjectREST.class);
      bind(PathParamREST.class);
      bind(FormParamREST.class);
      bind(ConsumesREST.class);
      bind(JsonREST.class);
      bind(PathREST.class);
      bind(ProducesREST.class);
      bind(QueryParamREST.class);
      bind(SubResourcesREST.class);
    }
  }
}
