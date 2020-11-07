package rest.example;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ServerProperties;
import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.servlet.ServletProperties;
import rest.example.api.PathREST;
import rest.example.server.JettyServer;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("NotNullNullableValidation")
public final class JerseyLauncher {

  public static void main(String[] args) throws Exception {
    final Server server = JettyServer.build();

    ServletContextHandler defaultContext = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
    final ServletHolder servletHolder = defaultContext.addServlet(ServletContainer.class, "/");
    final Map<String, String> param = new HashMap<>();
    param.put(ServletProperties.JAXRS_APPLICATION_CLASS, JerseyLauncher.class.getName());
    param.put(ServerProperties.PROVIDER_PACKAGES, PathREST.class.getPackage().getName());
    param.put(ServerProperties.PROVIDER_CLASSNAMES, JacksonFeature.class.getName());
    servletHolder.setInitParameters(param);

    server.setHandler(defaultContext);

    server.start();
  }
}
