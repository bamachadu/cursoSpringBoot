package com.bamachadu.curso.application.casoDeUso;

import java.io.Serializable;

import com.bamachadu.curso.entity.domain.Categoria;

public class CategoriaFindAll implements Serializable {
  private static final long serialVersionUID = 1L;

  private Integer id;
  private String nome;

  public CategoriaFindAll() {
  }

  public CategoriaFindAll(Categoria categoria) {
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
