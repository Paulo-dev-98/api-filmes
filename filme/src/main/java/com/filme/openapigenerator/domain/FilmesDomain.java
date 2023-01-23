package com.filme.openapigenerator.domain;

import org.springframework.stereotype.Component;

@Component	
public class FilmesDomain {
	
	  private Long id;

	  private String nome;

	  private String genero;

	  private String sinopse;

	  private String dataDeEstreia;
	  
	  public FilmesDomain() {
		  
	  }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public String getDataDeEstreia() {
		return dataDeEstreia;
	}

	public void setDataDeEstreia(String dataDeEstreia) {
		this.dataDeEstreia = dataDeEstreia;
	}
	  
}
