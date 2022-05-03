package com.bamachadu.curso.presentation.controllers;

import com.bamachadu.curso.application.service.PedidoService;
import com.bamachadu.curso.entity.domain.Pedido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoController {

  @Autowired
  private PedidoService service;

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ResponseEntity<Pedido> find(@PathVariable Integer id) {
    Pedido obj = service.findById(id);
    return ResponseEntity.ok().body(obj);
  }
}
