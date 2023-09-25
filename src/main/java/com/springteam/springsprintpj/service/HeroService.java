package com.springteam.springsprintpj.service;

import java.math.BigDecimal;
import java.util.List;

import com.springteam.springsprintpj.model.dto.HeroDto;

public interface HeroService {

	public HeroDto findById(BigDecimal id);

	public List<HeroDto> findAll();

	public HeroDto save(HeroDto hero);

	public List<HeroDto> saveAll(List<HeroDto> heros);

}
