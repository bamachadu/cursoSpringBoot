package com.bamachadu.curso.application.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.bamachadu.curso.entity.domain.Cliente;

import org.hibernate.validator.constraints.Length;

public class ClienteDto implements Serializable {
  private static final long serialVersionUID = 1L;

  private Integer id;

  @NotEmpty(message = "Preenchimento obrigatório")
  @Length(min = 5, max = 120, message = "Tamanho entre 5 e 120")
  private String nome;

  @NotEmpty(message = "Preenchimento obrigatório")
  @Email(message = "Email inválido")
  private String email;

  public ClienteDto() {
  }

  public ClienteDto(Cliente obj) {
    id = obj.getId();
    nome = obj.getNome();
    email = obj.getEmail();
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

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

}
