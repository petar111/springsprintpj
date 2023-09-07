/**
 * 
 */
package com.springteam.springsprintpj.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.google.common.collect.ImmutableList;
import com.springteam.springsprintpj.configuration.ApplicationConfiguration;
import com.springteam.springsprintpj.model.entity.Hero;
import com.springteam.springsprintpj.model.exception.hero.HeroNotFoundException;


/**
 * @author PJeremic
 *
 */
class HeroRepositoryTest {
	
	private AnnotationConfigApplicationContext context;
	private HeroRepository heroRepository;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
		heroRepository = context.getBean("heroRepository", HeroRepository.class);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		context.close();
	}

	@Test
	void testInsertOneThenRetreive() {
		Hero heroToInsert = Hero.builder().name("HeroTest").id(BigDecimal.ONE).description("Hero test.").hitpoints(BigDecimal.valueOf(1500L))
				.build();
		Hero insertedHero = heroRepository.save(heroToInsert);
		
		assertEquals(heroToInsert.getId(), insertedHero.getId());
		
		Hero heroRetreived = heroRepository.findById(BigDecimal.ONE)
				.orElseThrow(() -> new HeroNotFoundException(BigDecimal.ONE));
		
		assertEquals(BigDecimal.ONE, heroRetreived.getId());
	}
	
	@Test
	void testInsertMoreThenRetreive() {
		Hero heroToInsert = Hero.builder().name("HeroTest").id(BigDecimal.ONE).description("Hero test.").hitpoints(BigDecimal.valueOf(1500L))
				.build();
		Hero heroToInsert2 = Hero.builder().name("HeroTest2").id(BigDecimal.valueOf(2)).description("Hero test.").hitpoints(BigDecimal.valueOf(1500L))
				.build();
		Hero heroToInsert3 = Hero.builder().name("HeroTest3").id(BigDecimal.valueOf(3)).description("Hero test.").hitpoints(BigDecimal.valueOf(1500L))
				.build();
		
		List<Hero> heros = ImmutableList.of(heroToInsert, heroToInsert2, heroToInsert3);
		
		List<Hero> insertedHeros = ImmutableList.copyOf(heroRepository.saveAll(heros));
		
		assertEquals(heros.size(), insertedHeros.size());
		
		List<Hero> herosRetreived = ImmutableList.copyOf(heroRepository.findAll());
		
		assertEquals(heros.size(), herosRetreived.size());
	}

}
