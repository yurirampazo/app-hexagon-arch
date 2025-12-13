package com.test.hexagonal.adapters.out;

import com.test.hexagonal.adapters.out.repository.CustomerRepository;
import com.test.hexagonal.adapters.out.repository.mapper.CustomerMapper;
import com.test.hexagonal.application.core.domain.Customer;
import com.test.hexagonal.application.ports.out.UpdateCustomerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateCustomerAdapter implements UpdateCustomerOutputPort {

  @Autowired
  private CustomerRepository customerRepository;

  @Autowired
  private CustomerMapper customerMapper;

  @Override
  public void update(Customer customer) {
    var customerEntity = customerMapper.toCustomerEntity(customer);
    customerRepository.save(customerEntity);
  }
}
