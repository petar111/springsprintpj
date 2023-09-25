package com.springteam.springsprintpj.configuration.validation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class ValidationConfiguration {

	@Bean
	public LocalValidatorFactoryBean getValidatorFactory() {
		LocalValidatorFactoryBean factory = new LocalValidatorFactoryBean();
		return factory;
	}

}
