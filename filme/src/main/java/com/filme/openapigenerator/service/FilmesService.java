package com.filme.openapigenerator.service;

import java.util.List;

import com.filme.openapigenerator.filme.model.FilmesDto;

public interface FilmesService {

	FilmesDto postFilme(FilmesDto filmesDto);
	FilmesDto putFilme(String filmesId, FilmesDto filmesDto);
	List<FilmesDto> getFilme();
	void deleteFilme(String id);
	FilmesDto getFilmePorId(String id);
	
}
