package com.springteam.springsprintpj.messaging.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springteam.springsprintpj.model.dto.HeroDto;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class HeroMessagingSender {

	private final ObjectMapper objectMapper = new ObjectMapper();
	private final JmsTemplate template;

	public void sendHeroToCreate(HeroDto heroDto) {

		try {
			template.convertAndSend(objectMapper.writeValueAsString(heroDto));
		} catch (JmsException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

}
