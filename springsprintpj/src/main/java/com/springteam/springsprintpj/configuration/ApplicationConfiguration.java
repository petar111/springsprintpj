package com.springteam.springsprintpj.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.springteam.springsprintpj.configuration.db.OracleDatabaseConfiguration;
import com.springteam.springsprintpj.configuration.db.jdbc.JdbcConfiguration;
import com.springteam.springsprintpj.configuration.db.jpa.PersistenceConfiguration;
import com.springteam.springsprintpj.configuration.inject.InjectConfiguration;
import com.springteam.springsprintpj.configuration.jms.JmsConfiguration;
import com.springteam.springsprintpj.configuration.validation.ValidationConfiguration;

@Configuration
@Import({ OracleDatabaseConfiguration.class, InjectConfiguration.class, PersistenceConfiguration.class,
		JdbcConfiguration.class, JmsConfiguration.class, ValidationConfiguration.class })
public class ApplicationConfiguration {

}
