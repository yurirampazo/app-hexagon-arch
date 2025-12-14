package com.test.hexagonal.adapters.in.controller.mapper;

import com.test.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.test.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.test.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerRequestMapper {

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "address", ignore = true)
  @Mapping(target = "isCpfValid", ignore = true)
  Customer toCustomer(CustomerRequest customerRequest);

  @Mapping(target = "isValidCpf", source = "isCpfValid")
  CustomerResponse toCustomerResponse(Customer customer);
}
