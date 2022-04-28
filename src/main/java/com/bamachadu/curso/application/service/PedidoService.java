package com.bamachadu.curso.application.service;

import java.util.Optional;

import com.bamachadu.curso.application.helpers.ObjectNotFoundException;
import com.bamachadu.curso.entity.domain.Pedido;
import com.bamachadu.curso.repositories.PedidoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

  @Autowired
  private PedidoRepository repository;

  public Pedido findById(Integer id) {
    Optional<Pedido> obj = repository.findById(id);
    return obj.orElseThrow(() -> new ObjectNotFoundException(
      "Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
  }
}
