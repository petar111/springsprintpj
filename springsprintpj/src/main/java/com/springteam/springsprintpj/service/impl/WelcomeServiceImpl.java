package com.springteam.springsprintpj.service.impl;

import org.springframework.stereotype.Service;

import com.springteam.springsprintpj.service.WelcomeService;

@Service
public class WelcomeServiceImpl implements WelcomeService {

	@Override
	public void printWelcomeHeader() {
		System.out.println("======================================================");
		System.out.println("=====All rigths reserved.=============================");
		System.out.println("=====Welcome to my application.=======================");
		System.out.println("======================================================");
	}

}
