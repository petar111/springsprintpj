package com.springteam.springsprintpj.configuration.inject;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "com.springteam.springsprintpj.main", "com.springteam.springsprintpj.service",
		"com.springteam.springsprintpj.repository", "com.springteam.springsprintpj.mapper",
		"com.springteam.springsprintpj.messaging", "com.springteam.springsprintpj.errorhandler" })
public class InjectConfiguration {
}
