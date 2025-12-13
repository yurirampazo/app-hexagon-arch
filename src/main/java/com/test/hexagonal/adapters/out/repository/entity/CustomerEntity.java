package com.test.hexagonal.adapters.out.repository.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collation = "customers")
public class CustomerEntity {
  @Id
  private String id;
  private String name;
  private AddressEntity address;
  private String cpf;
  private Boolean isValidCpf;
}
