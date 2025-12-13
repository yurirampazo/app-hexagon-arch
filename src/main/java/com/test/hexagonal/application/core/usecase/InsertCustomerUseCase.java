package com.test.hexagonal.application.core.usecase;

import com.test.hexagonal.application.core.domain.Customer;
import com.test.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.test.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.test.hexagonal.application.ports.out.InsertCustomerOutputPort;

public class InsertCustomerUseCase implements InsertCustomerInputPort {

  private final FindAddressByZipCodeOutputPort addressByZipCodeOutputPort;
  private final InsertCustomerOutputPort insertCustomerOutputPort;

  public InsertCustomerUseCase(FindAddressByZipCodeOutputPort addressByZipCodeOutputPort,
                               InsertCustomerOutputPort insertCustomerOutputPort) {
    this.addressByZipCodeOutputPort = addressByZipCodeOutputPort;
    this.insertCustomerOutputPort = insertCustomerOutputPort;
  }

  @Override
  public void insert(Customer customer, String zipCode) {
    var address = addressByZipCodeOutputPort.find(zipCode);
    customer.setAddress(address);

    insertCustomerOutputPort.insert(customer);
  }
}
