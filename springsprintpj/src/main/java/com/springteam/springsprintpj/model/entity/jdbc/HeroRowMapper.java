package com.springteam.springsprintpj.model.entity.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springteam.springsprintpj.model.entity.Hero;

public class HeroRowMapper implements RowMapper<Hero> {

	@Override
	public Hero mapRow(ResultSet rs, int rowNum) throws SQLException {
		return Hero.builder().id(rs.getBigDecimal("id")).name(rs.getString("name"))
				.hitpoints(rs.getBigDecimal("hitpoints")).build();
	}

}
