package com.springteam.springsprintpj.configuration.db.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;

import com.springteam.springsprintpj.configuration.db.H2DatabaseConfiguration;
import com.springteam.springsprintpj.configuration.db.OracleDatabaseConfiguration;

@Configuration
@Import({ OracleDatabaseConfiguration.class, H2DatabaseConfiguration.class })
public class JdbcConfiguration {

	@Autowired
	private OracleDatabaseConfiguration oracleDatabaseConfiguration;
	@Autowired
	private H2DatabaseConfiguration h2DatabaseConfiguration;

	@Bean
	public JdbcTemplate jdbcTemplate() {

		JdbcTemplate template = new JdbcTemplate(h2DatabaseConfiguration.getDataSource());

		return template;
	}

}
