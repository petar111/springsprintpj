package com.springteam.springsprintpj.mapper;

import com.springteam.springsprintpj.model.dto.HeroDto;
import com.springteam.springsprintpj.model.entity.Hero;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-16T13:20:56+0200",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 18.0.2 (Eclipse Adoptium)"
)
@Component
public class HeroMapperImpl implements HeroMapper {

    @Override
    public HeroDto toDto(Hero hero) {
        if ( hero == null ) {
            return null;
        }

        HeroDto.HeroDtoBuilder heroDto = HeroDto.builder();

        heroDto.id( hero.getId() );
        heroDto.name( hero.getName() );
        heroDto.description( hero.getDescription() );
        heroDto.hitpoints( hero.getHitpoints() );

        return heroDto.build();
    }

    @Override
    public Hero toEntity(HeroDto heroDto) {
        if ( heroDto == null ) {
            return null;
        }

        Hero.HeroBuilder hero = Hero.builder();

        hero.id( heroDto.getId() );
        hero.name( heroDto.getName() );
        hero.description( heroDto.getDescription() );
        hero.hitpoints( heroDto.getHitpoints() );

        return hero.build();
    }

    @Override
    public List<HeroDto> toDtoList(List<Hero> hero) {
        if ( hero == null ) {
            return null;
        }

        List<HeroDto> list = new ArrayList<HeroDto>( hero.size() );
        for ( Hero hero1 : hero ) {
            list.add( toDto( hero1 ) );
        }

        return list;
    }

    @Override
    public List<Hero> toEntityList(List<HeroDto> heroDto) {
        if ( heroDto == null ) {
            return null;
        }

        List<Hero> list = new ArrayList<Hero>( heroDto.size() );
        for ( HeroDto heroDto1 : heroDto ) {
            list.add( toEntity( heroDto1 ) );
        }

        return list;
    }
}
