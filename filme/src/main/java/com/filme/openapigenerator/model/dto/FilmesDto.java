package com.filme.openapigenerator.model.dto;

import java.io.Serializable;


//@Schema(name = "filmes", description = "filmes")
//@JsonTypeName("filmes")
//@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-01-23T16:21:32.562289100-03:00[America/Sao_Paulo]")
public class FilmesDto implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long id;

  private String nome;

  private String genero;

  private String sinopse;

  private String dataDeEstreia;

  public FilmesDto id(Long id) {
    this.id = id;
    return this;
  }
  
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public FilmesDto nome(String nome) {
    this.nome = nome;
    return this;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public FilmesDto genero(String genero) {
    this.genero = genero;
    return this;
  }

  public String getGenero() {
    return genero;
  }

  public void setGenero(String genero) {
    this.genero = genero;
  }

  public FilmesDto sinopse(String sinopse) {
    this.sinopse = sinopse;
    return this;
  }
  
  public String getSinopse() {
    return sinopse;
  }

  public void setSinopse(String sinopse) {
    this.sinopse = sinopse;
  }

  public FilmesDto dataDeEstreia(String dataDeEstreia) {
    this.dataDeEstreia = dataDeEstreia;
    return this;
  }
  
  public String getDataDeEstreia() {
    return dataDeEstreia;
  }

  public void setDataDeEstreia(String dataDeEstreia) {
    this.dataDeEstreia = dataDeEstreia;
  }

}

