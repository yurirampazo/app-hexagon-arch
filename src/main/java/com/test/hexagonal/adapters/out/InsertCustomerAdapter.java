package com.test.hexagonal.adapters.out;

import com.test.hexagonal.adapters.out.repository.CustomerRepository;
import com.test.hexagonal.adapters.out.repository.mapper.CustomerMapper;
import com.test.hexagonal.application.core.domain.Customer;
import com.test.hexagonal.application.ports.out.InsertCustomerOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InsertCustomerAdapter implements InsertCustomerOutputPort {

  private final CustomerRepository customerRepository;
  private final CustomerMapper customerMapper;

  @Override
  public void insert(Customer customer) {
    customerRepository.save(customerMapper.toCustomerEntity(customer));
  }
}
