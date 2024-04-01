package com.learn_java_spring.models;

import java.io.Serializable;
import java.util.Objects;

public class Person implements Serializable {
  private static final long serialVersionUID = 1L;

  private Long id;
  private String firstName;
  private String lastName;
  private String address;
  private String gender;

  public Person() {
  }

  public Person(Long id, String firstName, String lastName, String address, String gender) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.gender = gender;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstName() {
    return this.firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getAddress() {
    return this.address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getGender() {
    return this.gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  // @Override
  // public boolean equals(Object o) {
  // return EqualsBuilder.reflectionEquals(this, o);
  // }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstName, lastName, address, gender);
  }

}
