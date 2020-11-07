package rest.example;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.jboss.resteasy.plugins.server.servlet.HttpServletDispatcher;
import rest.example.server.JettyServer;

@SuppressWarnings("NotNullNullableValidation")
public final class RESTEasyLauncher {

  public static void main(String[] args) throws Exception {
    final Server server = JettyServer.build();

    ServletContextHandler context = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
    context.addServlet(HttpServletDispatcher.class, "/");
    context.addEventListener(new GuiceListener());

    server.setHandler(context);
    server.start();
  }
}
