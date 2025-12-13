package com.test.hexagonal.adapters.in.controller.response;

import com.test.hexagonal.adapters.out.client.response.AddressResponse;
import lombok.Data;

@Data
public class CustomerResponse {
  private String name;
  private String cpf;
  private AddressResponse address;
  private Boolean isValidCpf;
}
