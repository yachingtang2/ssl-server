package com.tang.sslserver;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecuredServerController {

  @GetMapping("/secured")
  public String secured() {
    return "Hello user!!!";
  }
}
