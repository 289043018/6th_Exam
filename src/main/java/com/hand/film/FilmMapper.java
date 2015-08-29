package com.hand.film;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class FilmMapper implements RowMapper<FilmEntity> {
	 public FilmEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		 FilmEntity film = new FilmEntity();
		 film.setId(rs.getLong("id"));
		 film.setTitle(rs.getString("title"));
		 film.setDescription(rs.getString("description"));
		 film.setLanguage_id(rs.getLong("language_id"));
		 return film;
	 }
}
