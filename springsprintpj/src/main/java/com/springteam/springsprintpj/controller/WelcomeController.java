package com.springteam.springsprintpj.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springteam.springsprintpj.messaging.sender.HeroMessagingSender;
import com.springteam.springsprintpj.model.dto.HeroDto;

@RestController
@RequestMapping("welcome")
public class WelcomeController {

	@Autowired
	private HeroMessagingSender heroMessageSender;

	@GetMapping("herosample")
	public HeroDto getHeroSample() {
		return heroSample();
	}

	@PostMapping("heromessage")
	public void sendHeroMessage() {
		heroMessageSender.sendHeroToCreate(heroSample());
	}

	private HeroDto heroSample() {
		return HeroDto.builder().id(BigDecimal.ZERO).name("Raziel").hitpoints(BigDecimal.valueOf(1000L)).build();
	}

}
