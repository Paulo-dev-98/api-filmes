package com.filme.openapigenerator.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.filme.openapigenerator.domain.FilmesDomain;
import com.filme.openapigenerator.filme.api.FilmesApi;
import com.filme.openapigenerator.model.FilmesDto;

@RestController
public class FilmeController implements FilmesApi{
	
	  private final HashMap<Long, FilmesDomain> indentificador = new HashMap<>();
	  private Long index = 0L;
	  
	  @Autowired
	  private FilmesDomain filmesDomain;
	  
    @Override
    public ResponseEntity<FilmesDto> postFilme() {
    	FilmesDomain filmes = new FilmesDomain();
    	filmes.setId(index);
        filmes.setNome(filmesDomain.getNome());
        filmes.setGenero(filmesDomain.getGenero());
        filmes.setDataDeEstreia(filmesDomain.getDataDeEstreia());
        filmes.setSinopse(filmesDomain.getSinopse());
 
        indentificador.put(index, filmes);
        index++;
 
        return ResponseEntity.ok(domainToApi(filmes));
    }
    
    private FilmesDto domainToApi(FilmesDomain filmesDomain) {
        FilmesDto filmesDto = new FilmesDto();
        filmesDto.setId(filmesDomain.getId());
        filmesDto.setNome(filmesDomain.getNome());
        filmesDto.setGenero(filmesDomain.getGenero());
        filmesDto.setDataDeEstreia(filmesDomain.getDataDeEstreia());
        filmesDto.setSinopse(filmesDomain.getSinopse());

        return filmesDto;
    }
    
}
