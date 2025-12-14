package com.test.hexagonal.application.core.usecase;

import com.test.hexagonal.application.core.domain.Customer;
import com.test.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.test.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.test.hexagonal.application.ports.out.InsertCustomerOutputPort;
import com.test.hexagonal.application.ports.out.SendCpfForValidationOutputPort;

public class InsertCustomerUseCase implements InsertCustomerInputPort {

  private final FindAddressByZipCodeOutputPort addressByZipCodeOutputPort;
  private final InsertCustomerOutputPort insertCustomerOutputPort;
  private final SendCpfForValidationOutputPort sendCpfForValidationOutputPort;

  public InsertCustomerUseCase(FindAddressByZipCodeOutputPort addressByZipCodeOutputPort,
                               InsertCustomerOutputPort insertCustomerOutputPort,
                               SendCpfForValidationOutputPort sendCpfForValidationOutputPort) {
    this.addressByZipCodeOutputPort = addressByZipCodeOutputPort;
    this.insertCustomerOutputPort = insertCustomerOutputPort;
    this.sendCpfForValidationOutputPort = sendCpfForValidationOutputPort;
  }

  @Override
  public void insert(Customer customer, String zipCode) {
    var address = addressByZipCodeOutputPort.find(zipCode);
    customer.setAddress(address);
    insertCustomerOutputPort.insert(customer);
    sendCpfForValidationOutputPort.send(customer.getCpf());
  }
}
