package com.test.hexagonal.adapters.in.controller.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerRequest {
  @NotBlank
  private String name;
  @NotBlank
  @Size(min = 11, max = 11)
  private String cpf;
  @NotBlank
  private String zipCode;
}
