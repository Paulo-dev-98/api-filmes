package com.filme.openapigenerator.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.filme.openapigenerator.exception.ResourceNotFoundException;
import com.filme.openapigenerator.mapper.FilmesMapper;
import com.filme.openapigenerator.repository.FilmesRepository;

@Component
public class FilmeValidator {
	
	@Autowired
	FilmesRepository filmesRepository;
	
	@Autowired
	FilmesMapper filmesMapper;
	
	public void validate(Long id) {
		if(filmesRepository.findById(id).isEmpty()){
			throw new ResourceNotFoundException("O id: " + id + " não foi encontrado" );
		}	       
	}
}
