package com.bamachadu.curso.application.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import com.bamachadu.curso.entity.domain.Categoria;

import org.hibernate.validator.constraints.Length;

public class CategoriaDto implements Serializable {
  private static final long serialVersionUID = 1L;

  private Integer id;

  @NotEmpty(message = "Preenchimento obrigatório")
  @Length(min=5, max = 80, message = "Tamanho entre 5 e 80")
  private String nome;

  public CategoriaDto() {
  }

  public CategoriaDto(Categoria categoria) {
    id = categoria.getId();
    nome = categoria.getNome();
  }

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

}
