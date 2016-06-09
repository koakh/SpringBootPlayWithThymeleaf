package com.koakh.model.customer;

import com.koakh.Application;
import io.bloco.faker.Faker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class CustomerFaker {

  private static final Logger log = LoggerFactory.getLogger(Application.class);

  public static void fakeDate(
    CustomerRepository repository,
    CustomerLocaleRepository customerLocaleRepository,
    Long noOfRecords
  ) {

    try {
      Faker faker = new Faker();

      for (int i = 0; i < noOfRecords; i++) {

        ArrayList<CustomerLocale> locale = new ArrayList<>();

        Customer customer = new Customer(
          faker.name.firstName(),
          faker.name.lastName(),
          faker.date.birthday(),
          faker.internet.email(),
          locale
        );

        //US
        CustomerLocale customerLocale1 = new CustomerLocale(
          "US",
          String.format("US:%s",faker.lorem.words(20).toString()),
          faker.lorem.words(20).toString(),
          customer
        );
//customerLocaleRepository.save(customerLocale1);
        locale.add(customerLocale1);
        //PT
        CustomerLocale customerLocale2 = new CustomerLocale(
          "PT",
          String.format("US:%s",
            faker.lorem.words(20).toString()),
          faker.lorem.words(20).toString(),
          customer
        );
//customerLocaleRepository.save(customerLocale2);
        locale.add(customerLocale2);
        //US
        CustomerLocale customerLocale3 = new CustomerLocale(
          "ES",
          String.format("US:%s",faker.lorem.words(20).toString()),
          faker.lorem.words(20).toString(),
          customer
        );
//customerLocaleRepository.save(customerLocale3);
        locale.add(customerLocale3);

        log.info(String.format("Creating: %s", customer.toString()));
        repository.save(customer);

        //customer.setLocale(locale);
        //repository.save(customer);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

