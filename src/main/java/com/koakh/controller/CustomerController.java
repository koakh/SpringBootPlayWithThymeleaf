package com.koakh.controller;

import com.koakh.model.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CustomerController {

  //AutoWire Repository
  @Autowired
  CustomerRepository customerRepository;

  @RequestMapping("customer")
  public String customer(
    @RequestParam(value = "id", required = true, defaultValue = "1")
    int id, Model model
    ){
      model.addAttribute("id", id);
      //model.addAttribute("customer", customerRepository.findOne(10L));
      model.addAttribute("customers", customerRepository.findAll());
      return "customer";
    }
}
