package com.filme.openapigenerator.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filme.openapigenerator.filme.api.FilmesApi;
import com.filme.openapigenerator.filme.model.FilmesDto;
import com.filme.openapigenerator.service.FilmesService;

@RestController
@RequestMapping("/api/filmes")
public class FilmesController implements FilmesApi {
	
	Logger logger = LogManager.getLogger(FilmesController.class);

	@Autowired
	private FilmesService filmesService;
	
	@GetMapping
	public ResponseEntity<List<FilmesDto>> getFilmes(){
	    if(logger.isDebugEnabled()) {
            logger.debug("Listar filmes");
        }
		return ResponseEntity.ok(filmesService.getFilme());
	}
	
    @GetMapping(value = "/{id}")
    public ResponseEntity<FilmesDto> getFilmesById(@PathVariable("id") String id) {
        if(logger.isDebugEnabled()) {
            logger.debug("Buscar Filme de Id {}", id);
        }
        return ResponseEntity.ok(filmesService.getFilmePorId(id));
    }

	@PostMapping
	public ResponseEntity<FilmesDto> postFilme(@RequestBody FilmesDto filmes) {
        if(logger.isDebugEnabled()) {
            logger.debug("Salvar filme - {}", filmes);
        }
		return ResponseEntity.ok(filmesService.postFilme(filmes));
	}
	
	@PutMapping(value = "/put")
	public ResponseEntity<FilmesDto> putFilme(@RequestBody FilmesDto filmes) {
		if(logger.isDebugEnabled()) {
			logger.debug("Atualizar filme - {}", filmes);
		}
		return ResponseEntity.ok(filmesService.putFilme(filmes));
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<FilmesDto> deletarFilme(@PathVariable("id") Long id){
	    if(logger.isDebugEnabled()) {
            logger.debug("Deletar Filme");
        }
		filmesService.deleteFilme(id);
		return ResponseEntity.ok().build();
	}
}
