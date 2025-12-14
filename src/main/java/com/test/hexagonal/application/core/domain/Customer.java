package com.test.hexagonal.application.core.domain;

@SuppressWarnings("ALL")
public class Customer {
  private String id;
  private String name;
  private Address address;
  private String cpf;
  private Boolean isCpfValid;

  public Customer() {
    isCpfValid = false;
  }

  public Customer(String id, Boolean isCpfValid, String cpf, Address address, String name) {
    this.id = id;
    this.isCpfValid = isCpfValid;
    this.cpf = cpf;
    this.address = address;
    this.name = name;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Boolean getIsCpfValid() {
    return isCpfValid;
  }

  public void setIsCpfValid(Boolean cpfValid) {
    isCpfValid = cpfValid;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
