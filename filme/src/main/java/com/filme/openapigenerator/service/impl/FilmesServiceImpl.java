package com.filme.openapigenerator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filme.openapigenerator.filme.model.FilmesDto;
import com.filme.openapigenerator.mapper.FilmesMapper;
import com.filme.openapigenerator.model.Filmes;
import com.filme.openapigenerator.repository.FilmesRepository;
import com.filme.openapigenerator.service.FilmesService;

@Service
public class FilmesServiceImpl implements FilmesService {
	
	@Autowired
	FilmesRepository filmesRepository;
	
	@Autowired
	FilmesMapper filmesMapper;

	@Override
	public FilmesDto postFilme(FilmesDto filmesDto) {
        Filmes filmes = filmesMapper.modelMapperFilmes().map(filmesDto, Filmes.class);
        Filmes cadFilme = filmesRepository.save(filmes);
        return filmesMapper.modelMapperFilmes().map(cadFilme, FilmesDto.class);
	}

}
