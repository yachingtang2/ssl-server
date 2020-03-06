package com.tang.sslserver;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@ExtendWith(MockitoExtension.class)
public class SecuredServerControllerTest {

  @InjectMocks
  private SecuredServerController controller;

  @Autowired
  private MockMvc mvc;

  @BeforeEach
  void setUp() {
    mvc = standaloneSetup(controller).build();
  }

  @Test
  void secured() throws Exception {
    mvc.perform(MockMvcRequestBuilders.get("/secured"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string("Hello user!!!"));
  }
}
