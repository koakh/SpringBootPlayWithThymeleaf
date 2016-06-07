package com.koakh;

import com.koakh.model.country.CountryFaker;
import com.koakh.model.country.CountryRepository;
import com.koakh.model.customer.CustomerFaker;
import com.koakh.model.customer.CustomerLocaleRepository;
import com.koakh.model.customer.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@SpringBootApplication
public class Application {

  private static final Logger log = LoggerFactory.getLogger(Application.class);

  //Get Values from application.properties
  @Value("${spring.datasource.url}")
  private String datasourceUrl;
  @Value("${model.faker.records.customer}")
  private long apFakerRecordsCustomer;
  @Value("${model.faker.records.country}")
  private long apFakerRecordsCountry;

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Bean
  public CommandLineRunner loadData(
    CustomerRepository customerRepository,
    CustomerLocaleRepository customerLocaleRepository,
    CountryRepository countryRepository
  ) {
    return (args) -> {

      //Show DatasourceUrl
      log.info(String.format("datasourceUrl: %s", datasourceUrl));

      //Mock Data
      if (customerRepository.count() == 0) {
        CustomerFaker.fakeDate(customerRepository, customerLocaleRepository, apFakerRecordsCustomer);
      }
      if (countryRepository.count() == 0) {
        CountryFaker.fakeDate(countryRepository, apFakerRecordsCountry);
      }
    };
  }

  @Bean
  //Configuring The LocaleResolver
  public LocaleResolver localeResolver() {
    SessionLocaleResolver slr = new SessionLocaleResolver();
    slr.setDefaultLocale(Locale.US);
    return slr;
  }

  @Bean
  //Configuring a LocaleChangeInterceptor
  public LocaleChangeInterceptor localeChangeInterceptor() {
    LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
    lci.setParamName("lang");
    return lci;
  }

  @Bean
  public ReloadableResourceBundleMessageSource messageSource() {
    ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
    //messageSource.setBasename("classpath:locale/messages");
    messageSource.setBasename("classpath:messages");
    messageSource.setCacheSeconds(3600); //refresh cache once per hour
    return messageSource;
  }
}
