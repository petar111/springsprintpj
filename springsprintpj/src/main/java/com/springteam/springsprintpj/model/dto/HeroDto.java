package com.springteam.springsprintpj.model.dto;

import java.math.BigDecimal;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HeroDto {

	private BigDecimal id;
	@NotNull
	@Size(max = 500, min = 1)
	private String name;
	private String description;
	@Min(1)
	private BigDecimal hitpoints;

}
