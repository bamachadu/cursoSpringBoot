package com.bamachadu.curso.application.service;

import java.util.Optional;

import com.bamachadu.curso.application.helpers.ObjectNotFoundException;
import com.bamachadu.curso.entity.domain.Cliente;
import com.bamachadu.curso.repositories.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

  @Autowired
  private ClienteRepository repository;

  public Cliente findById(Integer id) {
    Optional<Cliente> obj = repository.findById(id);
    //tratamento realizado para proteger contra a serialização Json cíclica
    return obj.orElseThrow(() -> new ObjectNotFoundException(
      "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
  }
}
