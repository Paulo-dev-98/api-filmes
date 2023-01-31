package com.filme.openapigenerator.service;

import java.util.List;

import com.filme.openapigenerator.filme.model.FilmesDto;

public interface FilmesService {

	FilmesDto postFilme(FilmesDto filmesDto);
	FilmesDto putFilme(FilmesDto filmesDto);
	List<FilmesDto> getFilme();
	void deleteFilme(Long id);
	FilmesDto getFilmePorId(String id);
	
}
