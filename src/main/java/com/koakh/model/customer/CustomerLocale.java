package com.koakh.model.customer;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "customerlocale")
public class CustomerLocale implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @Size(max = 5)
  private String locale;
  private String title;
  private String description;
  //@OneToMany(mappedBy = "locale", cascade = CascadeType.ALL)
  //private Set<Customer> customer;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "customer_id")
  private Customer customer;

  public CustomerLocale() {
  }

  public CustomerLocale(String locale, String title, String description, Customer customer) {
    this.locale = locale;
    this.title = title;
    this.description = description;
    this.customer = customer;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getLocale() {
    return locale;
  }

  public void setLocale(String locale) {
    this.locale = locale;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Customer getCustomer() {  return customer; }

  public void setCustomer(Customer customer) { this.customer = customer; }
}
