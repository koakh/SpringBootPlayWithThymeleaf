package com.koakh.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

  //Get Values from application.properties
  @Value("${spring.mvc.locale}")
  private String locale;

  @RequestMapping("/")
  public String home(Model model) {

    model.addAttribute("locale", locale);

    return "master";
  }
}
