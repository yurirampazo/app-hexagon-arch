package com.test.hexagonal.config;

import com.test.hexagonal.adapters.out.repository.FindCustomerByIdAdapter;
import com.test.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindCustomerConfig {

  @Bean
  public FindCustomerByIdUseCase findCustomerByIdUseCase(FindCustomerByIdAdapter findCustomerByIdAdapter) {
    return new FindCustomerByIdUseCase(findCustomerByIdAdapter);
  }
}
