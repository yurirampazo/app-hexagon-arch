package com.test.hexagonal.application.ports.out;

import com.test.hexagonal.application.core.domain.Address;

public interface FindAddressByZipCodeOutputPort {

  Address find(String zipCode);
}
