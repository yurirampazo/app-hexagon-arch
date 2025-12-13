package com.test.hexagonal.application.ports.out;

import com.test.hexagonal.application.core.domain.Customer;

import java.util.Optional;

public interface FindCustomerByIdOutputPort {

  Optional<Customer> find(String id);
}
