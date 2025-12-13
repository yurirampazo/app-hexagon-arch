package com.test.hexagonal.adapters.in.controller;

import com.test.hexagonal.adapters.in.controller.mapper.CustomerRequestMapper;
import com.test.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.test.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.test.hexagonal.application.ports.in.DeleteCustomerByIdInputPort;
import com.test.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.test.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.test.hexagonal.application.ports.in.UpdateCustomerInputPort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

  private final InsertCustomerInputPort insertCustomerInputPort;
  private final CustomerRequestMapper customerRequestMapper;
  private final FindCustomerByIdInputPort findCustomerByIdInputPort;
  private final UpdateCustomerInputPort updateCustomerInputPort;
  private final DeleteCustomerByIdInputPort deleteCustomerByIdInputPort;

  @PostMapping
  public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest customerRequest) {
    insertCustomerInputPort.insert(customerRequestMapper.toCustomer(customerRequest), customerRequest.getZipCode());
    return ResponseEntity.ok().build();
  }

  @GetMapping("/{id}")
  public ResponseEntity<CustomerResponse> findCustomerById(@PathVariable final String id) {
    var customer = findCustomerByIdInputPort.find(id);
    if (customer == null) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(customerRequestMapper.toCustomerResponse(customer));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Void> update(@PathVariable final String id,
                                     @RequestBody CustomerRequest customerRequest) {
    var customer = customerRequestMapper.toCustomer(customerRequest);
    customer.setId(id);
    updateCustomerInputPort.update(customer, customerRequest.getZipCode());
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable String id) {
    deleteCustomerByIdInputPort.delete(id);
    return ResponseEntity.noContent().build();
  }
}
