package com.bamachadu.curso.application.dto;

import java.io.Serializable;

public class ClienteNewDto implements Serializable {
  private static final long serialVersionUID = 1L;

  private String nome;
  private String email;
  private String cpfCnpj;
  private Integer tipoCliente;

  private String logradouro;
  private String numero;
  private String complemento;
  private String bairro;
  private String cep;

  private String telefone1;
  private String telefone2;
  private String telefone3;

  private Integer cidadeId;

  public ClienteNewDto() {
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

  public String getCpfCnpj() {
    return this.cpfCnpj;
  }

  public void setCpfCnpj(String cpfCnpj) {
    this.cpfCnpj = cpfCnpj;
  }

  public Integer getTipoCliente() {
    return this.tipoCliente;
  }

  public void setTipoCliente(Integer tipoCliente) {
    this.tipoCliente = tipoCliente;
  }

  public String getLogradouro() {
    return this.logradouro;
  }

  public void setLogradouro(String logradouro) {
    this.logradouro = logradouro;
  }

  public String getNumero() {
    return this.numero;
  }

  public void setNumero(String numero) {
    this.numero = numero;
  }

  public String getComplemento() {
    return this.complemento;
  }

  public void setComplemento(String complemento) {
    this.complemento = complemento;
  }

  public String getBairro() {
    return this.bairro;
  }

  public void setBairro(String bairro) {
    this.bairro = bairro;
  }

  public String getCep() {
    return this.cep;
  }

  public void setCep(String cep) {
    this.cep = cep;
  }

  public String getTelefone1() {
    return this.telefone1;
  }

  public void setTelefone1(String telefone1) {
    this.telefone1 = telefone1;
  }

  public String getTelefone2() {
    return this.telefone2;
  }

  public void setTelefone2(String telefone2) {
    this.telefone2 = telefone2;
  }

  public String getTelefone3() {
    return this.telefone3;
  }

  public void setTelefone3(String telefone3) {
    this.telefone3 = telefone3;
  }

  public Integer getCidadeId() {
    return this.cidadeId;
  }

  public void setCidadeId(Integer cidadeId) {
    this.cidadeId = cidadeId;
  }

}
