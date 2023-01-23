package com.filme.openapigenerator.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;

/**
 * filmes
 */

@Schema(name = "Filmes", description = "filmes")
@JsonTypeName("Filmes")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-01-23T16:21:32.562289100-03:00[America/Sao_Paulo]")
public class FilmesDto {

  @JsonProperty("id")
  private Long id;

  @JsonProperty("nome")
  private String nome;

  @JsonProperty("genero")
  private String genero;

  @JsonProperty("sinopse")
  private String sinopse;

  @JsonProperty("data de estreia")
  private String dataDeEstreia;

  public FilmesDto id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  
  @Schema(name = "id", required = false)
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

  /**
   * Get nome
   * @return nome
  */
  
  @Schema(name = "nome", required = false)
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

  /**
   * Get genero
   * @return genero
  */
  
  @Schema(name = "genero", required = false)
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

  /**
   * Get sinopse
   * @return sinopse
  */
  
  @Schema(name = "sinopse", required = false)
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

  /**
   * Get dataDeEstreia
   * @return dataDeEstreia
  */
  
  @Schema(name = "data de estreia", required = false)
  public String getDataDeEstreia() {
    return dataDeEstreia;
  }

  public void setDataDeEstreia(String dataDeEstreia) {
    this.dataDeEstreia = dataDeEstreia;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FilmesDto filmes = (FilmesDto) o;
    return Objects.equals(this.id, filmes.id) &&
        Objects.equals(this.nome, filmes.nome) &&
        Objects.equals(this.genero, filmes.genero) &&
        Objects.equals(this.sinopse, filmes.sinopse) &&
        Objects.equals(this.dataDeEstreia, filmes.dataDeEstreia);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nome, genero, sinopse, dataDeEstreia);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FilmesDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
    sb.append("    genero: ").append(toIndentedString(genero)).append("\n");
    sb.append("    sinopse: ").append(toIndentedString(sinopse)).append("\n");
    sb.append("    dataDeEstreia: ").append(toIndentedString(dataDeEstreia)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

