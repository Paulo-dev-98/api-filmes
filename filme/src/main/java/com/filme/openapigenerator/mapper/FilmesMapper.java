package com.filme.openapigenerator.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.filme.openapigenerator.converter.FilmesConverter;
import com.filme.openapigenerator.filme.model.FilmesDto;
import com.filme.openapigenerator.model.Filmes;

@Component
public class FilmesMapper {
	
    @Bean
    public ModelMapper modelMapperFilmes() {
        final ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        final PropertyMap<Filmes, FilmesDto> toDto = new PropertyMap<Filmes,FilmesDto>() {
            protected void configure() {
            	using(FilmesConverter.longToInteger())
                  .map(source.getId(), destination.getId());
                map().setNome(source.getName());
                map().setGenero(source.getCategory());
                map().setDataDeEstreia(source.getMoviePremiere());
                map().setSinopse(source.getSummary());
            }
        };

        final PropertyMap<FilmesDto, Filmes> toEntity = new PropertyMap<FilmesDto, Filmes>() {
            protected void configure() {
              using(FilmesConverter.integerToLong())
                .map(source.getId(), destination.getId());
              map().setName(source.getNome());
              map().setCategory(source.getGenero());
              map().setMoviePremiere(source.getDataDeEstreia());
              map().setSummary(source.getSinopse());
            }
        };

        modelMapper.addMappings(toDto);
        modelMapper.addMappings(toEntity);
        return modelMapper;
    }
}
