package com.springteam.springsprintpj.configuration.db;

import javax.sql.DataSource;

import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import lombok.AllArgsConstructor;

@Configuration
@PropertySource("classpath:application.properties")
@AllArgsConstructor
public class PostgreDatabaseConfiguration {

	@Autowired
	private Environment environment;

	@Bean("postgreDatasource")
	public DataSource getDataSource() {

		PGSimpleDataSource dataSource = new PGSimpleDataSource();
		
		dataSource.setServerNames(new String[] {
				environment.getProperty("postgre.datasource.host")
		});
		dataSource.setPortNumbers(new int[] {Integer.parseInt(environment.getProperty("postgre.datasource.port"))});
		dataSource.setDatabaseName(environment.getProperty("postgre.datasource.dbname"));
		dataSource.setUser(environment.getProperty("postgre.datasource.username"));
		dataSource.setPassword(environment.getProperty("postgre.datasource.password"));
	
		
		return dataSource;
	}
}
