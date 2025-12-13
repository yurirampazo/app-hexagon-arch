package com.test.hexagonal.adapters.out.repository.mapper;

import com.test.hexagonal.adapters.out.repository.entity.CustomerEntity;
import com.test.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
  CustomerEntity toCustomerEntity(Customer customer);

  Customer toCustomer(CustomerEntity customerEntity);
}
