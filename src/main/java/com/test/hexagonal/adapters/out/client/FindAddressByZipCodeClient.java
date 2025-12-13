package com.test.hexagonal.adapters.out.client;

import com.test.hexagonal.adapters.out.client.response.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "FindAddressByZipCodeClient", url = "${test.client.address.url}")
public interface FindAddressByZipCodeClient {

  @GetMapping("/{zipCode}")
  AddressResponse find(@PathVariable("zipCode") String zipCode);
}
