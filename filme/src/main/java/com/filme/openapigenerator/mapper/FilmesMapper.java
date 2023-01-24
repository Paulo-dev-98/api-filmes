package com.filme.openapigenerator.mapper;

import org.springframework.stereotype.Component;

import com.filme.openapigenerator.model.Filmes;
import com.filme.openapigenerator.model.dto.FilmesDto;

@Component
public class FilmesMapper {

	public FilmesDto toDto(Filmes filmes) {
		FilmesDto filmesDto = new FilmesDto();
		filmesDto.setId(filmes.getId());
		filmesDto.setNome(filmes.getName());
		filmesDto.setGenero(filmes.getCategory());
		filmesDto.setDataDeEstreia(filmes.getMoviePremiere());
		filmesDto.setSinopse(filmes.getSummary());
		return filmesDto;
	}

	public Filmes toEntity(FilmesDto filmesDto) {
       Filmes filmes = new Filmes();
       filmes.setId(filmesDto.getId());
       filmes.setName(filmesDto.getNome());
       filmes.setCategory(filmesDto.getGenero());
       filmes.setMoviePremiere(filmesDto.getDataDeEstreia());
       filmes.setSummary(filmesDto.getSinopse());
       return filmes;
	}

}
