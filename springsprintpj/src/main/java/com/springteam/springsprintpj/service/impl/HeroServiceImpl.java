package com.springteam.springsprintpj.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.springteam.springsprintpj.mapper.HeroMapper;
import com.springteam.springsprintpj.model.dto.HeroDto;
import com.springteam.springsprintpj.model.entity.Hero;
import com.springteam.springsprintpj.model.exception.hero.HeroNotFoundException;
import com.springteam.springsprintpj.repository.HeroRepository;
import com.springteam.springsprintpj.service.HeroService;

@Service
public class HeroServiceImpl implements HeroService {

	private final HeroRepository repository;
	private final HeroMapper mapper;

	public HeroServiceImpl(@Autowired @Qualifier("heroRepository") HeroRepository repository,
			@Autowired HeroMapper mapper) {
		super();
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public HeroDto findById(BigDecimal id) {
		return mapper.toDto(repository.findById(id).orElseThrow(() -> new HeroNotFoundException(id)));
	}

	@Override
	public List<HeroDto> findAll() {
		return mapper.toDtoList(Lists.newArrayList(repository.findAll()));
	}

	@Override
	public HeroDto save(HeroDto hero) {
		Hero savedHero = repository.save(mapper.toEntity(hero));
		return mapper.toDto(savedHero);
	}

	@Override
	public List<HeroDto> saveAll(List<HeroDto> heros) {
		List<Hero> savedHeros = ImmutableList.copyOf(repository.saveAll(mapper.toEntityList(heros)));
		return mapper.toDtoList(savedHeros);
	}

}
