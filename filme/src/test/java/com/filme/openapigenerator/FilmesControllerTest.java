package com.filme.openapigenerator;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.filme.openapigenerator.controller.FilmesController;
import com.filme.openapigenerator.filme.model.FilmesDto;
import com.filme.openapigenerator.service.FilmesService;

@ExtendWith(MockitoExtension.class)
public class FilmesControllerTest {
	
	@InjectMocks
	private FilmesController controller = new FilmesController();
	
	@Mock
	private FilmesService filmesService;
	
	@Mock
	private FilmesDto filmesDto;
	
	private MockMvc mockMvc;
	
	@BeforeEach
	public void setup() throws Exception {
		
		mockMvc = MockMvcBuilders.standaloneSetup(controller)
				.setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver()).build();
	}
	
	@Test
	public void cadFilme() throws Exception {
		Mockito.when(filmesService.postFilme(Mockito.any(FilmesDto.class))).thenReturn(Mockito.any(FilmesDto.class));
		ResultActions perform = this.mockMvc
				.perform(post("/api/filmes").contentType(MediaType.APPLICATION_JSON).content(
						"{ \"nome\": \"teste\" , \"genero\": \"teste\", \"dataDeEstreia\": \"teste\", \"sinopse\": \"teste\"}"));
			perform.andExpect(status().isOk());
	}

}
