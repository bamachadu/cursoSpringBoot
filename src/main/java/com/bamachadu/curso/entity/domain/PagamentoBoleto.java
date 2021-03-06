package com.bamachadu.curso.entity.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.bamachadu.curso.entity.models.EstadoPagamento;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class PagamentoBoleto extends Pagamento {
  private static final long serialVersionUID = 1L;

  @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
  private Date dataVencimento;
  
  @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
  private Date dataPagamento;

  public PagamentoBoleto() {
  }

  public PagamentoBoleto(Integer id, EstadoPagamento estado, Pedido pedido, Date dataVencimento, Date dataPagamento) {
    super(id, estado, pedido);
    this.dataVencimento = dataVencimento;
    this.dataPagamento = dataPagamento;
  }

  public Date getDataVencimento() {
    return this.dataVencimento;
  }

  public void setDataVencimento(Date dataVencimento) {
    this.dataVencimento = dataVencimento;
  }

  public Date getDataPagamento() {
    return this.dataPagamento;
  }

  public void setDataPagamento(Date dataPagamento) {
    this.dataPagamento = dataPagamento;
  }

}
