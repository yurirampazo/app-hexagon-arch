package com.test.hexagonal.adapters.out.repository.mapper;

import com.test.hexagonal.adapters.out.repository.entity.CustomerEntity;
import com.test.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

  @Mapping(target = "isValidCpf", ignore = true)
  CustomerEntity toCustomerEntity(Customer customer);

  @Mapping(target = "isCpfValid", source = "isValidCpf", ignore = true)
  Customer toCustomer(CustomerEntity customerEntity);
}
