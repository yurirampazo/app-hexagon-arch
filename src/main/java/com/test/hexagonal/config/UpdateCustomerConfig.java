package com.test.hexagonal.config;

import com.test.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.test.hexagonal.adapters.out.InsertCustomerAdapter;
import com.test.hexagonal.adapters.out.UpdateCustomerAdapter;
import com.test.hexagonal.adapters.out.repository.FindCustomerByIdAdapter;
import com.test.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import com.test.hexagonal.application.core.usecase.InsertCustomerUseCase;
import com.test.hexagonal.application.core.usecase.UpdateCustomerUseCase;
import com.test.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.test.hexagonal.application.ports.out.UpdateCustomerOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerConfig {

  @Bean
  public UpdateCustomerUseCase updateCustomerUseCase(FindCustomerByIdUseCase findCustomerByIdUseCase,
                                                     FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
                                                     UpdateCustomerAdapter updateCustomerAdapter) {

    return new UpdateCustomerUseCase(findCustomerByIdUseCase, findAddressByZipCodeAdapter, updateCustomerAdapter);
  }
}
