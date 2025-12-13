package com.test.hexagonal.application.ports.in;

import com.test.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerInputPort {

  void update(Customer customer, String zipCode);
}
