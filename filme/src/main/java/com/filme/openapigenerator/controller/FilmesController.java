package com.filme.openapigenerator.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filme.openapigenerator.filme.api.FilmesApi;
import com.filme.openapigenerator.filme.model.FilmesDto;
import com.filme.openapigenerator.service.FilmesService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class FilmesController implements FilmesApi {
	
	Logger logger = LogManager.getLogger(FilmesController.class);

	@Autowired
	private FilmesService filmesService;
	
	@Override
	public ResponseEntity<List<FilmesDto>> getfilmes(){
	    if(logger.isDebugEnabled()) {
            logger.debug("Listar filmes");
        }
		return ResponseEntity.ok(filmesService.getFilme());
	}
	
    @Override
    public ResponseEntity<FilmesDto> getfilmesbyid(@PathVariable("filmesId") String filmesId) {
        if(logger.isDebugEnabled()) {
            logger.debug("Buscar Filme de Id {}", filmesId);
        }
        return new ResponseEntity<>(filmesService.getFilmePorId(filmesId), HttpStatus.OK);
    }

	@Override
	public ResponseEntity<FilmesDto> createFilmes(@Valid @RequestBody FilmesDto body) {
        if(logger.isDebugEnabled()) {
            logger.debug("Salvar filme - {}", body);
        }
        return new ResponseEntity<>(filmesService.postFilme(body), HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<FilmesDto> updatefilmes(String filmesId, @Valid @RequestBody FilmesDto body) {
		if(logger.isDebugEnabled()) {
			logger.debug("Atualizar filme - {}", body);
		}
		return new ResponseEntity<>(filmesService.putFilme(filmesId, body), HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<Void> deletefilmes(@PathVariable("filmesId") String filmesId){
	    if(logger.isDebugEnabled()) {
            logger.debug("Deletar Filme");
        }
		filmesService.deleteFilme(filmesId);
		return ResponseEntity.ok().build();
	}
}
