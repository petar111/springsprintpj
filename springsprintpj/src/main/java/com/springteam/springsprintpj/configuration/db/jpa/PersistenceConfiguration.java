package com.springteam.springsprintpj.configuration.db.jpa;

import java.io.IOException;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.springteam.springsprintpj.configuration.db.H2DatabaseConfiguration;
import com.springteam.springsprintpj.configuration.db.OracleDatabaseConfiguration;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableTransactionManagement
@Import({ OracleDatabaseConfiguration.class, H2DatabaseConfiguration.class })
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@EnableJpaRepositories(basePackages = { "com.springteam.springsprintpj.repository" })
public class PersistenceConfiguration {

	private static final String HIBERNATE_PROPERTIES_FILE_LOCATION = "db/hibernate/hibernate.properties";

	private final OracleDatabaseConfiguration oracleDatabaseConfiguration;
	private final H2DatabaseConfiguration h2DatabaseConfiguration;

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(h2DatabaseConfiguration.getDataSource());
		em.setPackagesToScan(new String[] { "com.springteam.springsprintpj.model" });

		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(additionalProperties());

		return em;
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

		return transactionManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	Properties additionalProperties() {

		try {

			Resource resource = new ClassPathResource(HIBERNATE_PROPERTIES_FILE_LOCATION);

			Properties properties = new Properties();
			properties.load(resource.getInputStream());

			return properties;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}

}
