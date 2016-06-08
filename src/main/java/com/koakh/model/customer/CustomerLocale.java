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
  @OneToMany(mappedBy = "locale", cascade = CascadeType.ALL)
  private Set<Customer> customer;

  public CustomerLocale () {
  }

  public CustomerLocale (String locale, String title, String description) {
    this.locale = locale;
    this.title = title;
    this.description = description;
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

  public Set<Customer> getCustomer() {
    return customer;
  }

  public void setCustomer(Set<Customer> customer) {
    this.customer = customer;
  }
}
