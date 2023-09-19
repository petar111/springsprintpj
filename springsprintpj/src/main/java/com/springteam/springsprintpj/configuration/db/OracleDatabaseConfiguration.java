package com.springteam.springsprintpj.configuration.db;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import lombok.AllArgsConstructor;
import oracle.jdbc.pool.OracleDataSource;

@Configuration
@PropertySource("classpath:/application.properties")
@AllArgsConstructor
public class OracleDatabaseConfiguration {

	@Autowired
	private Environment environment;

	@Bean("oracleDataSource")
	public DataSource getDataSource() {

		try {

			System.out.println(environment.getProperty("datasource.url"));

			OracleDataSource dataSource = new OracleDataSource();

			dataSource.setUser(environment.getProperty("datasource.username"));
			dataSource.setPassword(environment.getProperty("datasource.password"));
			dataSource.setURL(environment.getProperty("datasource.url"));

			return dataSource;

		} catch (SQLException e) {
			throw new RuntimeException();
		}

	}
}
