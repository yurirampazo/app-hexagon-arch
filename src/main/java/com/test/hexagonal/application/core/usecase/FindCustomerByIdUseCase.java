package com.test.hexagonal.application.core.usecase;

import com.test.hexagonal.application.core.domain.Customer;
import com.test.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.test.hexagonal.application.ports.out.FindCustomerByIdOutputPort;

public class FindCustomerByIdUseCase implements FindCustomerByIdInputPort {


  private final FindCustomerByIdOutputPort findCustomerByIdOutputPort;

  public FindCustomerByIdUseCase(FindCustomerByIdOutputPort findCustomerByIdOutputPort) {
    this.findCustomerByIdOutputPort = findCustomerByIdOutputPort;
  }

  @Override
  public Customer find(String id) {
    return findCustomerByIdOutputPort.find(id).orElseThrow(()
        -> new RuntimeException("Customer not found"));
  }

}
