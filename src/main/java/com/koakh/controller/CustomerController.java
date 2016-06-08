package com.koakh.controller;

import com.koakh.model.book.Book;
import com.koakh.model.book.BookCategory;
import com.koakh.model.book.BookCategoryRepository;
import com.koakh.model.book.BookRepository;
import com.koakh.model.customer.CustomerRepository;
import com.koakh.service.MessageByLocaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CustomerController {

  //AutoWire Repository
  @Autowired
  CustomerRepository customerRepository;
  @Autowired
  BookRepository bookRepository;
  @Autowired
  BookCategoryRepository bookCategoryRepository;

  @Autowired
  MessageByLocaleService messageByLocaleService;

  @RequestMapping("customer")
  public String customer(
    @RequestParam(value = "id", required = true, defaultValue = "1")
    int id, Model model
    ){
      model.addAttribute("id", id);
      //model.addAttribute("customer", customerRepository.findOne(10L));
      model.addAttribute("customers", customerRepository.findAll());

      //Test messageByLocaleService
      String invalidLogin = messageByLocaleService.getMessage("user.login.invalid");

      BookCategory bookCategory = new BookCategory("SciFi");
      bookCategoryRepository.save(bookCategory);
      Book book = new Book("Matrix", bookCategory);
      bookRepository.save(book);
      book = new Book("Lord of Rings", bookCategory);
      bookRepository.save(book);
      book = new Book("Hidden", bookCategory);
      bookRepository.save(book);


      return "customer";
    }
}
