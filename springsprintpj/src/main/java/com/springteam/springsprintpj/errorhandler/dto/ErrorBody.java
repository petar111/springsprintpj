package com.springteam.springsprintpj.errorhandler.dto;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ErrorBody {

	HttpStatus status;
	String message;
	String stackTrace;

}
