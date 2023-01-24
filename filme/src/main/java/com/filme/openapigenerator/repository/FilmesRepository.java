package com.filme.openapigenerator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.filme.openapigenerator.model.Filmes;

@Repository
public interface FilmesRepository extends JpaRepository<Filmes, Long> {

}
