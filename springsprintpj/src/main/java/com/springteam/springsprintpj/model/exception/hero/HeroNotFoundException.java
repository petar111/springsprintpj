package com.springteam.springsprintpj.model.exception.hero;

import java.math.BigDecimal;

import com.springteam.springsprintpj.model.exception.EntityNotFoundByIdException;

public class HeroNotFoundException extends EntityNotFoundByIdException {

	private static final long serialVersionUID = 6782727438412098002L;

	public HeroNotFoundException(BigDecimal id) {
		super("Hero not found by id", id);
	}

}
