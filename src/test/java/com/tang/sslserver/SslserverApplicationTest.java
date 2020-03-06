package com.tang.sslserver;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SslserverApplicationTest {

  private SslServerApplication application;

  @BeforeEach
  void setUp() {
    application = new SslServerApplication();
  }

  @Test
  void init() {
    assertThat(application).isNotNull();
  }
}
