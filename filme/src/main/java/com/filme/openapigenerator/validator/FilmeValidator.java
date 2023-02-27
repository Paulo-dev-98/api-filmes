package com.filme.openapigenerator.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.filme.openapigenerator.exception.CampoException;
import com.filme.openapigenerator.exception.ResourceNotFoundException;
import com.filme.openapigenerator.filme.model.FilmesDto;
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
	
	public void validate(FilmesDto filmesDto) {
		if(filmesDto.getNome() == null || filmesDto.getNome().isEmpty() || 
		   filmesDto.getNome().length() > 20) {
			throw new CampoException("O campo nome não pode ser vazio, "
					+ "nulo ou ter mais de 20 caracteres");
		}
		
		if(filmesDto.getGenero() == null || filmesDto.getGenero().isEmpty() ||
				filmesDto.getGenero().length() > 15) {
			throw new CampoException("O campo gênero não pode ser vazio, nulo ou ter mais"
					+ "de 15 caracteres");
		}
		
		if(filmesDto.getSinopse() == null || filmesDto.getSinopse().isEmpty() ||
				filmesDto.getSinopse().length() > 200) {
			throw new CampoException("O campo sinopse não pode ser vazio, nulo ou ter mais"
					+ "de 200 caracteres");
		}
	}
}
