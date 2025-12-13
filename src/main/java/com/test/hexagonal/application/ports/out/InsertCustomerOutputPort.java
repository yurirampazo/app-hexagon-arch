package com.test.hexagonal.application.ports.out;

import com.test.hexagonal.application.core.domain.Customer;

public interface InsertCustomerOutputPort {

  void insert(Customer customer);
}
