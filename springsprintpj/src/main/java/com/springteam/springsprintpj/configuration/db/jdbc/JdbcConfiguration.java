package com.springteam.springsprintpj.configuration.db.jdbc;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;

import com.springteam.springsprintpj.configuration.db.H2DatabaseConfiguration;
import com.springteam.springsprintpj.configuration.db.OracleDatabaseConfiguration;

@Configuration
@Import({ OracleDatabaseConfiguration.class, H2DatabaseConfiguration.class })
public class JdbcConfiguration {

	private final DataSource dataSource;

	@Autowired
	public JdbcConfiguration(@Qualifier("oracleDataSource") DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
	public JdbcTemplate jdbcTemplate() {

		JdbcTemplate template = new JdbcTemplate(dataSource);

		return template;
	}

}
