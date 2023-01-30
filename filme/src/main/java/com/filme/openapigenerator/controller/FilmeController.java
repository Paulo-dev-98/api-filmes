package com.filme.openapigenerator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filme.openapigenerator.filme.api.FilmesApi;
import com.filme.openapigenerator.model.dto.FilmesDto;
import com.filme.openapigenerator.service.FilmesService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
@RequestMapping("/api/filmes")
public class FilmeController implements FilmesApi {
	
	Logger logger = LogManager.getLogger(FilmeController.class);

	@Autowired
	private FilmesService filmesService;

	@PostMapping
	public ResponseEntity<FilmesDto> postFilme(@RequestBody FilmesDto filmes) {
        if(logger.isDebugEnabled()) {
            logger.debug("Salvar filme - {}", filmes);
        }
		return ResponseEntity.ok(filmesService.postFilme(filmes));
	}
}
