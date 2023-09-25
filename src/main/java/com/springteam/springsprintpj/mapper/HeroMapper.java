package com.springteam.springsprintpj.mapper;

import java.util.List;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import com.springteam.springsprintpj.model.dto.HeroDto;
import com.springteam.springsprintpj.model.entity.Hero;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface HeroMapper {

	HeroDto toDto(Hero hero);

	Hero toEntity(HeroDto heroDto);

	List<HeroDto> toDtoList(List<Hero> hero);

	List<Hero> toEntityList(List<HeroDto> heroDto);
}
