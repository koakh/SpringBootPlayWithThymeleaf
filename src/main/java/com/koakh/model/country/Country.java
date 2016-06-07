package com.koakh.model.country;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "country")
public class Country {

  @Id
  @GeneratedValue
  private Long id;
  @NotNull
  private String name;
  @NotNull
  private String code2;
  //@OneToMany
  //@JoinColumn(name = "id")
  //private List<Customer> customer;

  protected Country() {
  }

  public Country(String name, String code2) {
    this.name = name;
    this.code2 = code2;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCode2() {
    return code2;
  }

  public void setCode2(String code2) {
    this.code2 = code2;
  }

  @Override
  public String toString() {
    return String.format("Country[id=%d, name='%s', code2='%s']",
        id, name, code2);
  }
}