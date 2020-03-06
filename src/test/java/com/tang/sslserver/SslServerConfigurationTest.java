package com.tang.sslserver;

import org.apache.catalina.connector.Connector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;

import static org.assertj.core.api.Assertions.assertThat;

class SslServerConfigurationTest {

  private SslServerConfiguration configuration;

  @BeforeEach
  void setUp() {
    configuration = new SslServerConfiguration();
  }

  @Test
  public void initializeTomcat() {
    ServletWebServerFactory webServer = configuration.servletContainer();

    TomcatServletWebServerFactory tomcat = (TomcatServletWebServerFactory) webServer;

    System.out.println("YCT - " + tomcat.getTomcatContextCustomizers());

    Connector connector = tomcat.getAdditionalTomcatConnectors().get(0);
    assertThat(tomcat.getAdditionalTomcatConnectors().size()).isEqualTo(1);
    assertThat(connector.getScheme()).isEqualTo("http");
    assertThat(connector.getSecure()).isFalse();
    assertThat(connector.getPort()).isEqualTo(8080);
    assertThat(connector.getRedirectPort()).isEqualTo(8443);
  }
}
