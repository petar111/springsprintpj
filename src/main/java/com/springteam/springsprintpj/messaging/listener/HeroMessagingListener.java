package com.springteam.springsprintpj.messaging.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springteam.springsprintpj.model.dto.HeroDto;
import com.springteam.springsprintpj.service.HeroService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class HeroMessagingListener {

	private final ObjectMapper objectMapper = new ObjectMapper();
	private final HeroService heroService;

	@JmsListener(containerFactory = "jmsListenerContainerFactory", destination = "springsprintpjQueue")
	public void process(Message heroMessage) {

		try {
			TextMessage textMessage = (TextMessage) heroMessage;
			HeroDto heroDto = objectMapper.readValue(textMessage.getText(), HeroDto.class);
			heroService.save(heroDto);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (JMSException e) {
			e.printStackTrace();
		}

	}

}
