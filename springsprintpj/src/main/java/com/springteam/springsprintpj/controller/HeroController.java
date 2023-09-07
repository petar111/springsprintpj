package com.springteam.springsprintpj.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springteam.springsprintpj.model.dto.HeroDto;
import com.springteam.springsprintpj.service.HeroService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("hero")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class HeroController {

	private final HeroService service;

	@GetMapping("{id}")
	public HeroDto getHeroById(@PathVariable BigDecimal id) {
		return service.findById(id);
	}

	@GetMapping("all")
	public List<HeroDto> getAll() {
		return service.findAll();
	}

	@PostMapping("add")
	public HeroDto addHero(@RequestBody HeroDto hero) {
		return service.save(hero);
	}

	@PostMapping("addall")
	public List<HeroDto> addAllHeros(@RequestBody List<HeroDto> heros) {
		return service.saveAll(heros);
	}

}
