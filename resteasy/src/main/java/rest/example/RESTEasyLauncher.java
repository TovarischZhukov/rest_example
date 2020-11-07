package rest.example;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.HttpConnectionFactory;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.jboss.resteasy.plugins.server.servlet.HttpServletDispatcher;

@SuppressWarnings("NotNullNullableValidation")
public final class RESTEasyLauncher {

  public static void main(String[] args) throws Exception {
    final Server server = new Server();
    final ServerConnector serverConnector = new ServerConnector(server, new HttpConnectionFactory());
    serverConnector.setHost("localhost");
    serverConnector.setPort(3466);
    server.setConnectors(new Connector[]{serverConnector});

    ServletContextHandler context = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
    context.addServlet(HttpServletDispatcher.class, "/");
    context.addEventListener(new GuiceListener());

    server.setHandler(context);
    server.start();
  }
}
