package com.test.hexagonal.adapters.out;

import com.test.hexagonal.adapters.out.client.FindAddressByZipCodeClient;
import com.test.hexagonal.adapters.out.client.mapper.AddressMapper;
import com.test.hexagonal.application.core.domain.Address;
import com.test.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindAddressByZipCodeAdapter implements FindAddressByZipCodeOutputPort {

  private final FindAddressByZipCodeClient findAddressByZipCodeClient;
  private final AddressMapper addressMapper;

  @Override
  public Address find(String zipCode) {
    var addressResponse = findAddressByZipCodeClient.find(zipCode);
    return addressMapper.toAddress(addressResponse);
  }
}
