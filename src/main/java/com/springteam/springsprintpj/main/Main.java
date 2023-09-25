package com.springteam.springsprintpj.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.springteam.springsprintpj.configuration.ApplicationConfiguration;
import com.springteam.springsprintpj.service.WelcomeService;

@Component
public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

		WelcomeService welcomeService = ctx.getBean(WelcomeService.class);
		welcomeService.printWelcomeHeader();

		ctx.close();
	}

}
