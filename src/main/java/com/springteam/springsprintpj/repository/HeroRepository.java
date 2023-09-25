package com.springteam.springsprintpj.repository;

import java.math.BigDecimal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springteam.springsprintpj.model.entity.Hero;

@Repository
public interface HeroRepository extends CrudRepository<Hero, BigDecimal> {

}
