package com.test.hexagonal.application.ports.out;

import com.test.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerOutputPort {

  void update(Customer customer);
}
