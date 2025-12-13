package com.test.hexagonal.adapters.out.client.mapper;

import com.test.hexagonal.adapters.out.client.response.AddressResponse;
import com.test.hexagonal.application.core.domain.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {
  Address toAddress(AddressResponse addressResponse);
}
