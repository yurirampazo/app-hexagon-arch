package com.test.hexagonal.adapters.out.client.response;

public record AddressResponse(
  String street,
  String city,
  String state
) {}