package com.springteam.springsprintpj.configuration.db;

import javax.sql.DataSource;

import org.h2.jdbcx.JdbcDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import lombok.AllArgsConstructor;

@Configuration
@PropertySource("classpath:db/dbh2.properties")
@AllArgsConstructor
public class H2DatabaseConfiguration {
	
	@Autowired
	private Environment environment;
	
	@Bean("h2DataSource")
	public DataSource getDataSource() {
		JdbcDataSource dataSource = new JdbcDataSource();
		dataSource.setUrl(environment.getProperty("datasource.url"));
		
		return dataSource;
	}

}
