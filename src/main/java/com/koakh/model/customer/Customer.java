package com.koakh.model.customer;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @NotNull
  private String firstName;
  @NotNull
  private String lastName;
  @NotNull
  private Date bornIn;
  @NotNull
  private String email;
  //private Country country;
  //@OneToMany
  //@JoinColumn(name = "id")
  //private List<customerLocale> locale;
  @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
  private List<CustomerLocale> locale;

  protected Customer() {
  }

  public Customer(String firstName, String lastName, Date bornIn, String email) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.bornIn = bornIn;
    this.email = email;
  }

  public Customer(String firstName, String lastName, Date bornIn, String email, List<CustomerLocale> locale)
  {
    this.firstName = firstName;
    this.lastName = lastName;
    this.bornIn = bornIn;
    this.email = email;
    this.locale = locale;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Date getBornIn() {
    return bornIn;
  }

  public void setBornIn(Date bornIn) {
    this.bornIn = bornIn;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public List<CustomerLocale> getLocale() { return locale; }

  public void setLocale(List<CustomerLocale> locale) { this.locale = locale; }

  @Override
  public String toString() {
    return String.format("Customer[id=%d, firstName='%s', lastName='%s', bornIn='%s', email='%s']",
        id, firstName, lastName, bornIn, email);
  }
}