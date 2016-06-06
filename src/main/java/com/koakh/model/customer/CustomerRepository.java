package com.koakh.model.customer;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

  List<Customer> findByLastNameStartsWithIgnoreCase(String lastName);
  List<Customer> findById(Long id);
}