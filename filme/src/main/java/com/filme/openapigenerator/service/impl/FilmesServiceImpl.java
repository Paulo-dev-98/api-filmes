package com.filme.openapigenerator.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filme.openapigenerator.converter.FilmesConverter;
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
    public List<FilmesDto> getFilme() {
        List<Filmes> filmes = filmesRepository.findAll();
        return listFilmesToDto(filmes);
    }
    
    @Override
    public FilmesDto getFilmePorId(String id) {
        Filmes filmes = filmesRepository
                           .findById(FilmesConverter.stringToLong(id))
                           .orElse(new Filmes());
        return filmesMapper.modelMapperFilmes().map(filmes, FilmesDto.class);
    }

	@Override
	public FilmesDto postFilme(FilmesDto filmesDto) {
        Filmes filmes = filmesMapper.modelMapperFilmes().map(filmesDto, Filmes.class);
        Filmes cadFilme = filmesRepository.save(filmes);
        return filmesMapper.modelMapperFilmes().map(cadFilme, FilmesDto.class);
	}
	
	@Override
	public FilmesDto putFilme(FilmesDto filmesDto) {
		Filmes filmes = filmesMapper.modelMapperFilmes().map(filmesDto, Filmes.class);
		Filmes cadFilme = filmesRepository.save(filmes);
		return filmesMapper.modelMapperFilmes().map(cadFilme, FilmesDto.class);
	}
	
	@Override
	public void deleteFilme(Long id) {
		Filmes filmes = filmesRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("id não encontrado"));
		filmesRepository.delete(filmes);	
	}
	
    private List<FilmesDto> listFilmesToDto(List<Filmes> filmes) {
        return filmes.stream()
            .map(entity -> filmesMapper.modelMapperFilmes().map(entity, FilmesDto.class))
            .collect(Collectors.toList());
    }

}
