package com.koakh.model.customer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerLocaleRepository extends JpaRepository<CustomerLocale, Long> {

  List<Customer> findByLocale(String locale);
}