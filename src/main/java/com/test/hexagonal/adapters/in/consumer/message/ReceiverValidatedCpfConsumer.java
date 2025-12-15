package com.test.hexagonal.adapters.in.consumer.message;

import com.test.hexagonal.adapters.in.consumer.mapper.CustomerMessageMapper;
import com.test.hexagonal.application.ports.in.UpdateCustomerInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiverValidatedCpfConsumer {

  @Autowired
  private UpdateCustomerInputPort updateCustomerInputPort;

  @Autowired
  private CustomerMessageMapper customerMessageMapper;

  @KafkaListener(topics = "tp-cpf-validated", groupId = "testing")
  public void receive(CustomerMessage customerMessage) {
    var customer = customerMessageMapper.toCustomer(customerMessage);
    updateCustomerInputPort.update(customer, customerMessage.getZipCode());
  }
}
