package com.test.hexagonal.adapters.out.repository;

import com.test.hexagonal.adapters.out.repository.mapper.CustomerMapper;
import com.test.hexagonal.application.core.domain.Customer;
import com.test.hexagonal.application.ports.out.FindCustomerByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindCustomerByIdAdapter implements FindCustomerByIdOutputPort {


  @Autowired
  private CustomerRepository customerRepository;

  @Autowired
  private CustomerMapper customerMapper;

  @Override
  public Optional<Customer> find(String id) {
    return customerRepository.findById(id)
        .map(customerMapper::toCustomer);
  }
}
