package com.springteam.springsprintpj.repository.impl;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springteam.springsprintpj.model.entity.Hero;
import com.springteam.springsprintpj.model.entity.jdbc.HeroRowMapper;
import com.springteam.springsprintpj.repository.HeroRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class HeroRepositoryJdbcImpl implements HeroRepository {

	private final JdbcTemplate template;

	@Override
	public <S extends Hero> S save(S entity) {
		return null;
	}

	@Override
	public <S extends Hero> Iterable<S> saveAll(Iterable<S> entities) {
		return null;
	}

	@Override
	public Optional<Hero> findById(BigDecimal id) {

		return template.queryForStream("SELECT id, name, hitpoints from hero where id = ?", new HeroRowMapper(), id)
				.findAny();

	}

	@Override
	public boolean existsById(BigDecimal id) {
		return false;
	}

	@Override
	public Iterable<Hero> findAll() {
		return null;
	}

	@Override
	public Iterable<Hero> findAllById(Iterable<BigDecimal> ids) {
		return null;
	}

	@Override
	public long count() {
		return 0;
	}

	@Override
	public void deleteById(BigDecimal id) {
	}

	@Override
	public void delete(Hero entity) {
	}

	@Override
	public void deleteAllById(Iterable<? extends BigDecimal> ids) {
	}

	@Override
	public void deleteAll(Iterable<? extends Hero> entities) {
	}

	@Override
	public void deleteAll() {
	}

}
