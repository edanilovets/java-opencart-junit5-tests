package com.opencart.backend.model;

import java.util.Objects;

public class Customer {
  private String firstName;
  private String lastName;
  private String email;
  private String phone;
  private String password;
  private String address1;
  private String country;
  private String region;
  private String city;

  public Customer withFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public Customer withLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public Customer withEmail(String email) {
    this.email = email;
    return this;
  }

  public Customer withPhone(String phone) {
    this.phone = phone;
    return this;
  }

  public Customer withPassword(String password) {
    this.password = password;
    return this;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getEmail() {
    return email;
  }

  public String getPhone() {
    return phone;
  }

  public String getPassword() {
    return password;
  }

  public String getAddress1() {
    return address1;
  }

  public Customer withAddress1(String address1) {
    this.address1 = address1;
    return this;
  }

  public String getCountry() {
    return country;
  }

  public Customer withCountry(String country) {
    this.country = country;
    return this;
  }

  public String getRegion() {
    return region;
  }

  public Customer withRegion(String region) {
    this.region = region;
    return this;
  }

  public String getCity() {
    return city;
  }

  public Customer withCity(String city) {
    this.city = city;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Customer customer = (Customer) o;
    return Objects.equals(email, customer.email);
  }

  @Override
  public int hashCode() {

    return Objects.hash(email);
  }

}
