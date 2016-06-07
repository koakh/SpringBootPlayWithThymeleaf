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
        //US
        CustomerLocale customerLocale = new CustomerLocale("US", String.format("US:%s",faker.lorem.paragraph(1)), faker.lorem.paragraph(1));
        customerLocaleRepository.save(customerLocale);
        locale.add(customerLocale);
        //PT
        //customerLocale = new CustomerLocale("PT", String.format("PT:%s",faker.lorem.paragraph(1)), faker.lorem.paragraph(1));
        //customerLocaleRepository.save(customerLocale);
        //locale.add(customerLocale);
        //US
        //customerLocale = new CustomerLocale("ES", String.format("ES:%s",faker.lorem.paragraph(1)), faker.lorem.paragraph(1));
        //customerLocaleRepository.save(customerLocale);
        //locale.add(customerLocale);

        Customer customer = new Customer(
            faker.name.firstName(),
            faker.name.lastName(),
            faker.date.birthday(),
            faker.internet.email(),
            locale
        );

        log.info(String.format("Creating: %s", customer.toString()));
        repository.save(customer);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

