/**
 * 
 */
package com.springteam.springsprintpj.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.google.common.collect.Lists;
import com.springteam.springsprintpj.mapper.HeroMapper;
import com.springteam.springsprintpj.model.dto.HeroDto;
import com.springteam.springsprintpj.model.entity.Hero;
import com.springteam.springsprintpj.model.exception.hero.HeroNotFoundException;
import com.springteam.springsprintpj.repository.HeroRepository;

/**
 * @author petar
 *
 */
@ExtendWith(MockitoExtension.class)
class HeroServiceImplTest {

	@InjectMocks
	private HeroServiceImpl heroService;
	@Mock
	private HeroRepository heroRepository;
	@Mock
	private HeroMapper heroMapper;

	private Hero hero;
	private Hero hero2;

	private HeroDto heroDto;
	private HeroDto heroDto2;

	private List<Hero> heroList;
	private List<HeroDto> heroDtoList;

	private static final int HERO_LIST_SIZE = 2;
	private static final int HERO_EMPTY_LIST_SIZE = 0;

	private final BigDecimal heroId = BigDecimal.valueOf(1000L);
	private final BigDecimal heroId2 = BigDecimal.valueOf(1000L);

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
		hero = Hero.builder().name("HeroTest").id(heroId).description("Hero test.").hitpoints(BigDecimal.valueOf(1500L))
				.build();
		hero2 = Hero.builder().name("HeroTest2").id(heroId2).description("Hero test.")
				.hitpoints(BigDecimal.valueOf(1500L)).build();
		heroDto = HeroDto.builder().name("HeroTest").id(heroId).description("Hero test.")
				.hitpoints(BigDecimal.valueOf(1500L)).build();
		heroDto2 = HeroDto.builder().name("HeroTest2").id(heroId2).description("Hero test.")
				.hitpoints(BigDecimal.valueOf(1500L)).build();

		heroList = Lists.newArrayList(hero, hero2);
		heroDtoList = Lists.newArrayList(heroDto, heroDto2);

	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link com.springteam.springsprintpj.service.impl.HeroServiceImpl#findById(java.math.BigDecimal)}.
	 */
	@Test
	final void testFindtById() {

		when(heroRepository.findById(heroId)).thenReturn(Optional.of(hero)).thenThrow(HeroNotFoundException.class);
		when(heroMapper.toDto(hero)).thenReturn(heroDto);

		assertEquals(heroDto.getId(), heroService.findById(heroId).getId());
		assertThrows(HeroNotFoundException.class, () -> heroService.findById(heroId));
	}

	/**
	 * Test method for
	 * {@link com.springteam.springsprintpj.service.impl.HeroServiceImpl#findAll()}.
	 */
	@Test
	final void testFindAll() {

		when(heroMapper.toDtoList(anyList())).thenReturn(heroDtoList).thenReturn(Lists.newArrayList());
		when(heroRepository.findAll()).thenReturn(heroList).thenReturn(Lists.newArrayList());

		List<HeroDto> heroListAnswer = heroService.findAll();
		List<HeroDto> heroEmptyListAnswer = heroService.findAll();

		assertEquals(HERO_LIST_SIZE, heroListAnswer.size());
		assertEquals(HERO_EMPTY_LIST_SIZE, heroEmptyListAnswer.size());

	}

	/**
	 * Test method for
	 * {@link com.springteam.springsprintpj.service.impl.HeroServiceImpl#save(com.springteam.springsprintpj.model.dto.HeroDto)}.
	 */
	@Test
	final void testSave() {

		when(heroRepository.save(any())).thenReturn(hero);
		when(heroMapper.toEntity(heroDto)).thenReturn(hero);
		when(heroMapper.toDto(hero)).thenReturn(heroDto);

		assertEquals(heroDto.getName(), heroService.save(heroDto).getName());

	}
	
	@Test
	final void testSaveAll() {
		when(heroRepository.saveAll(any())).thenReturn(heroList);
		when(heroMapper.toEntityList(heroDtoList)).thenReturn(heroList);
		when(heroMapper.toDtoList(heroList)).thenReturn(heroDtoList);
		
		assertEquals(heroDtoList.size(), heroService.saveAll(heroDtoList).size());
	}

}
