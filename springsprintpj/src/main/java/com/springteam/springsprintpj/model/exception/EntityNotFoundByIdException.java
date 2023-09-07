package com.springteam.springsprintpj.model.exception;

import java.math.BigDecimal;

public class EntityNotFoundByIdException extends GlobalModelException {

	private static final long serialVersionUID = 4769955862540089380L;

	public EntityNotFoundByIdException(String message, BigDecimal id) {
		super(message + " : " + id);
	}

}
