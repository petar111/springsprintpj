package com.springteam.springsprintpj.configuration.jms;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListenerConfigurer;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerEndpointRegistrar;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.jms.support.destination.DestinationResolver;
import org.springframework.jms.support.destination.DynamicDestinationResolver;

@Configuration
@EnableJms
@ComponentScan(basePackages = { "com.springteam.springsprintpj.messaging" })
public class JmsConfiguration implements JmsListenerConfigurer {

	@Override
	public void configureJmsListeners(JmsListenerEndpointRegistrar registrar) {
		registrar.setContainerFactory(jmsListenerContainerFactory());
	}

	@Bean("jmsListenerContainerFactory")
	public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		factory.setConnectionFactory(connectionFactory());

		factory.setMessageConverter(jacksonJmsMessageConverter());
		factory.setSessionTransacted(true);
		factory.setConcurrency("5");
		return factory;
	}

	@Bean
	public DestinationResolver destinationResolver() {
		return new DynamicDestinationResolver();
	}

	@Bean
	public ConnectionFactory connectionFactory() {
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
		connectionFactory.setBrokerURL("tcp://localhost:61616");

		return connectionFactory;
	}

	@Bean
	public MessageConverter jacksonJmsMessageConverter() {
		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
		converter.setTargetType(MessageType.TEXT);
		converter.setTypeIdPropertyName("_type");
		return converter;
	}

	@Bean
	public Queue activeMQQueue() {
		Queue queue = new ActiveMQQueue("springsprintpjQueue");
		return queue;
	}

	@Bean
	public JmsTemplate jmsTemplate() {
		JmsTemplate template = new JmsTemplate();

		template.setConnectionFactory(connectionFactory());
		template.setDefaultDestination(activeMQQueue());

		return template;
	}

}
