package com.test.hexagonal.config;

import com.test.hexagonal.adapters.out.DeleteCustomerByIdAdapter;
import com.test.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.test.hexagonal.adapters.out.UpdateCustomerAdapter;
import com.test.hexagonal.adapters.out.repository.FindCustomerByIdAdapter;
import com.test.hexagonal.application.core.usecase.DeleteCustomerByIdUseCase;
import com.test.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import com.test.hexagonal.application.core.usecase.UpdateCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteCustomerConfig {

  @Bean
  public DeleteCustomerByIdUseCase deleteCustomerUseCase(FindCustomerByIdUseCase findCustomerByIdUseCase,
                                                         DeleteCustomerByIdAdapter deleteCustomerByIdAdapter) {

    return new DeleteCustomerByIdUseCase(findCustomerByIdUseCase, deleteCustomerByIdAdapter);
  }
}
