package com.test.hexagonal.application.ports.in;

import com.test.hexagonal.application.core.domain.Customer;

public interface InsertCustomerInputPort {
  void insert(Customer customer, String zipCode);
}
